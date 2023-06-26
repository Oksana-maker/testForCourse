package registration;

import Methdos.Methods;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.assertEquals;
import static xpath.and.methods.Xpath.*;

public class RegistrationNegative extends Methods {

    @Test(description = "devo-test")
    public static void FutterCheck1Carrier() throws InterruptedException, AWTException {
        ClickButton(ButtonPeople);
        ClickButton(ButtonRegistration);
        // getTXT(FieldRegistration);
        SendKeys(RegistrationUserName, "Мария123");
        SendKeys(RegistrationUserSurname, "Волк2@");
        SendKeys(RegisterUserPhone, "0000000000");
        SendKeys(RegisterUserEmail, "/@gmail123.com");
        SendKeys(RegisterUserPassword, "dpa@@");
        WaitLoadPage(5000);
        ClickButton(ButtonSubmit);
        assertEquals(getTXT(NegativeForm), "Реєстрація");
        assertEquals(getTXT(NegativeFormName), "Введіть своє ім'я кирилицею");
        assertEquals(getTXT(NegativeFormSurname), "Введіть своє прізвище кирилицею");
        assertEquals(getTXT(NegativeFormTelephone), "Введіть номер мобільного телефону");
        assertEquals(getTXT(NegativeFormEmail), "Введіть свою ел. пошту");
        assertEquals(getTXT(NegativeFormPasswordSymbol), "Не менше 6 символів");
        assertEquals(getTXT(NegativeFormPasswordNumbers), "Містити цифри");
        assertEquals(getTXT(NegativeFormPasswordUpper), "Містити великі літери");
        WaitLoadPage(5000);
    }
}