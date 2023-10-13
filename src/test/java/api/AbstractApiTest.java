package api;

import api.MethodsTest.PxstudioSaitStepMethods;
import api.MethodsTest.ReqresStepMethods;
import api.RunTest.RunReqresTest;
import api.settings.ConfigSteps;
import api.settings.ConfigurationConnection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class AbstractApiTest {
    protected ConfigSteps configSteps;

    protected ConfigurationConnection configurationConnect;
    protected ReqresStepMethods reqresStepMethods;
    protected PxstudioSaitStepMethods pxstudioSaitStepMethods;

//    @BeforeAll
//    public void SetUp() {
//        configSteps = new ConfigSteps();
//        configSteps.setUpRequestSpecifivation(configurationConnect.urlReqres());
//    }



    @BeforeEach
    public void setUp() {
        reqresStepMethods = new ReqresStepMethods();
        pxstudioSaitStepMethods = new PxstudioSaitStepMethods();

    }


}
