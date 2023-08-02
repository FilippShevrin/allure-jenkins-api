package api.MethodsTest;

import api.PxstudioSait.CatsFact;
import api.settings.ConfigSteps;
import api.settings.Varibables;
import org.junit.jupiter.api.Test;

import static api.settings.Varibables.urlCatFacts;
import static io.restassured.RestAssured.given;

public class PxstudioSaitStepMethods {

        public void checkAvatarAndIdTest1() {
            ConfigSteps.installSpecification(ConfigSteps.requestSpec(Varibables.urlReqres), ConfigSteps.responseSpecStatusCode(200));

            CatsFact response = given()
                    .when()
                    .get(urlCatFacts)
                    .then().log().all()
                    .extract().as(CatsFact.class);

            int sa = 1;
        }



}
