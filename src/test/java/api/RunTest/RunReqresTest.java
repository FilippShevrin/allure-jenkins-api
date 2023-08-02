package api.RunTest;

import api.AbstractApiTest;
import api.settings.TraceUnitExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TraceUnitExtension.class)
@Owner("Filipp Shevrin")
@DisplayName("Сайт Reqres")
public class RunReqresTest  extends AbstractApiTest {


    @Test
    @Tag("positive")
    @DisplayName("ReqresTest-T1: Проверка запроса get и проверка его окончания почты и подтверждения что открыли тот ids")
//    @Tag("ReqresTest-T1: Проверка запроса get и проверка его окончания почты и подтверждения что открыли тот ids")
    public void checkListAndTest() {
        reqresStepMethods.checkListAndTest();
    }

    @Test
    @DisplayName("ReqresTest-T2: Проверка логина и пароля и параметров что не null")
    @Tag("positive")
    public void checkRegisterTest() {
        reqresStepMethods.checkRegisterTest();
    }

    @Test
    @DisplayName("ReqresTest-T3: Проверка логина и пароля равного null, ожедаем 400 ошибку")
    @Tag("negative")
    public void checkUnRegisterTest() {
        reqresStepMethods.checkUnRegisterTest();
    }

    @Test
    @DisplayName("ReqresTest-T4: Проверка, что на сайте пользователи отсортированы по годам")
    @Tag("positive")
    public void checkYearNext() {
        reqresStepMethods.checkYearNext();
    }
    @Test
    @DisplayName("ReqresTest-T5: Проверка, отправления запроса на удаление")
    @Tag("positive")
    public void checkdelete() {
        reqresStepMethods.checkdelete();
    }
    @Test
    @DisplayName("ReqresTest-T6: Проверка, сравниваем время запроса и время на сервере")
    @Tag("positive")
    public void checkDatainServerAndJVM() {
        reqresStepMethods.checkDatainServerAndJVM();
    }
    @Test
    @DisplayName("ReqresTest-T7: Проверка, выполнение сравнения данных без POJO класса")
    @Tag("positive")
    public void checkAvatarsNoPojoTest() {
        reqresStepMethods.checkAvatarsNoPojoTest();
    }
    @Test
    @DisplayName("ReqresTest-T8: Проверка, выполнение регистрации без POJO класса с использованием Map и проверкой сразу в запросе")
    @Tag("positive")
    public void checkRegisterNoPojoTest() {
        reqresStepMethods.checkRegisterNoPojoTest();
    }
    @Test
    @DisplayName("ReqresTest-T9: Проверка, выполнение регистрации без POJO класса, с использованием Map и проверкой assertEquals")
    @Tag("positive")
    public void checkRegister2NoPojoTest() {
        reqresStepMethods.checkRegister2NoPojoTest();
    }
    @Test
    @DisplayName("ReqresTest-T10: Проверка, выполнение регистрации без POJO класса, на возврат текста ошибки в запросе")
    @Tag("negative")
    public void checkUnRegisterNoPojoTest() {
        reqresStepMethods.checkUnRegisterNoPojoTest();
    }
    @Test
    @DisplayName("ReqresTest-T11: Проверка, выполнение регистрации без POJO класса, на возврат текста ошибки через assertEquals")
    @Tag("negative")
    public void checkUnRegister2NoPojoTest() {
        reqresStepMethods.checkUnRegister2NoPojoTest();
    }
}
