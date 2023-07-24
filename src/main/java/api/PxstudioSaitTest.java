package api;

import api.PxstudioSait.CatsFact;
import api.settings.Specifications;
import api.settings.Varibables;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static api.settings.Varibables.urlCatFacts;
import static io.restassured.RestAssured.given;

public class PxstudioSaitTest {

        @Test
        public void checkAvatarAndIdTest1() {
            Specifications.installSpecification(Specifications.requestSpec(Varibables.urlReqres),Specifications.responseSpecStatusCode(200));

            Response response = given()
                    .when()
                    .get(urlCatFacts)
                    .then()
                    .extract().response();
            List<CatsFact> ads = response.body().jsonPath().getList("fact", CatsFact.class);
            int sa = 1;
        }



}
