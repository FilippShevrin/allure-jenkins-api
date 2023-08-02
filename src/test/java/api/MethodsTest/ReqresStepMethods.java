package api.MethodsTest;

import api.reqresSait.*;
import api.settings.ConfigSteps;
import api.settings.Varibables;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static api.settings.Varibables.urlReqresPage2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;


public class ReqresStepMethods {


    @DisplayName("ReqresTest-T1123")
    public void checkListAndTest(){
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));
//        ConfigSteps.installSpecification(ConfigSteps.setUpRequestSpecifivation(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));
        List<ResponseUserDataPage2> users = given()
                .when()
                .get(Varibables.urlReqresPage2)//post delete put get
                .then()
                .extract().body().jsonPath().getList("data.", ResponseUserDataPage2.class);

        users.stream().forEach(x-> assertTrue(x.getAvatar().contains((x.getId().toString()))));
        List<String> asd = users.stream().map(ResponseUserDataPage2::getEmail).collect(Collectors.toList());
//        assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in"))); // allMatch - все совпадения
        //второй способ
        List<String> avatars = users.stream().map(ResponseUserDataPage2::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        List<String> emaile = users.stream().map(ResponseUserDataPage2::getEmail).collect(Collectors.toList());
        for(int i= 0; i<avatars.size(); i++){
            assertTrue(emaile.get(i).endsWith("@reqres.in"));//другая реализация проверки почты
            assertTrue(avatars.get(i).contains(ids.get(i)));
            assertTrue(avatars.get(i).contains("-image.jpg"));// ищем внутри того что хранится в avatars то что нам нужно
        }

    }


    public void checkRegisterTest () {
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
         RequestRegister user = new RequestRegister("eve.holt@reqres.in","pistol");
//            user.setEmail("eve.holt@reqres.in");
//            user.setPassword("pistol");
        ResponseRegister register = given()
                .body(user)
                .when()
                .post(Varibables.urlRegister)
                .then()
                .extract().as(ResponseRegister.class);

        assertNotNull(register.getId());
        assertNotNull(register.getToken());
        assertEquals(id,register.getId());
        assertEquals(token,register.getToken());
    }

    @Test
    public void checkUnRegisterTest () {
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(400));
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
         RequestRegister user = new RequestRegister("sydney@fife","");
        ResponseErrorRegister register = given()
                .body(user)
                .when()
                .post(Varibables.urlRegister)
                .then()
                .extract().as(ResponseErrorRegister.class);

        assertNotNull(register.getError());
        assertEquals("Missing password",register.getError());

    }
//сравнение по годам


    public void checkYearNext(){
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));
        List<ResponseListResourseData> users = given()
                .when()
                .get(Varibables.urlResourse)//post delete put get
                .then()
                .extract().body().jsonPath().getList("data.", ResponseListResourseData.class);

        List<Integer> year = users.stream().map(x->x.getYear().intValue()).collect(Collectors.toList());
        List<Integer> sortedYear2 = year.stream().sorted().collect(Collectors.toList());
        for(int i= 0; i<year.size(); i++){
            assertEquals(sortedYear2,year,"Ошибка, ожидается что по порядку будет будет"+ sortedYear2.get(i) + " но фактически "+year.get(i));
        }
    }


    public void checkdelete(){
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(204));
        given()
                .when()
                .delete(Varibables.urlDelete);
    }




    public void checkDatainServerAndJVM(){ // не надежно!  часто время разнится
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));
        RequestUpdate userTime = new RequestUpdate();
        userTime.setJob("zion resident");
        userTime.setName("morpheus");
        ResponseUpdate register = given()
                .body(userTime)
                .when()
                .put(Varibables.urlUpdate)
                .then().log().all()
                .extract().as(ResponseUpdate.class);
        int i = 1;
        String regex = "(.{5})$";
        String currentTimeRegex = "(.{10})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(currentTimeRegex,"");; // заменяем последние 5 символов на ничего
        // сайт по  регулярным выражениям https://regex101.com/  ()
        System.out.println(currentTime);
        System.out.println(register.getUpdatedAt().replaceAll(regex,""));
        int a = 0;
//    assertEquals(currentTime,register.getUpdatedAt().replaceAll(regex,""),"Ошибка, время сервера :"+ currentTime + " время запроса :"+register.getUpdatedAt().replaceAll(regex,""));
    }


    public void checkAvatarsNoPojoTest(){
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));
        Response response = given()
                .when()
                .get(urlReqresPage2)
                .then()
                .body("page",equalTo(2))
                .body("data.id",notNullValue()) //содержится массив поэтому equalTo нельзя выбрать, выбираем noNullValue
                .body("data.email",notNullValue())
                .body("data.first_name",notNullValue())
                .body("data.last_name",notNullValue())
                .body("data.avatar",notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.get("data.email");
        List<Integer> ids = jsonPath.get("data.id");
        List<String> avatars = jsonPath.get("data.avatar");
        for(int i=0;i<avatars.size();i++){
            assertTrue(avatars.get(i).contains(ids.get(i).toString()));
            assertTrue(emails.stream().allMatch((x->x.endsWith("@reqres.in"))));
        }
        int a = 0 ;
    }


    public void checkRegisterNoPojoTest () {
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));
        Map<String,String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        given()
                .body(user)
                .when()
                .post(Varibables.urlRegister)
                .then()
                .body("id",equalTo(4))
                .body("token",equalTo("QpwL5tke4Pnpja7X4"))
                .extract().as(ResponseRegister.class);
    }


    public void checkRegister2NoPojoTest () {
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));
        Map<String,String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        Response response = given()
                .body(user)
                .when()
                .post(Varibables.urlRegister)
                .then()
//                .body("id",equalTo(4))
//                .body("token",equalTo("QpwL5tke4Pnpja7X4"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        String token = jsonPath.get("token");
        assertEquals(4,id);
        assertEquals("QpwL5tke4Pnpja7X4",token);

    }


    public void checkUnRegisterNoPojoTest () {
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(400));
       Map<String,String> user = new HashMap<>();
       user.put("email","sydney@fife");


        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
       given()
                .body(user)
                .when()
                .post(Varibables.urlRegister)
                .then()
               .body("error",equalTo("Missing password"));
    }

    @Test
    public void checkUnRegister2NoPojoTest () {
        ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(400));
        Map<String,String> user = new HashMap<>();
        user.put("email","sydney@fife");

        Response response = given()
                .body(user)
                .when()
                .post(Varibables.urlRegister)
                .then()
                .body("error",equalTo("Missing password"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("error");
        assertEquals("Missing password", error);
    }

}
