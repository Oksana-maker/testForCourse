package registration;

import Methdos.Methods;
import org.testng.annotations.Test;


import java.awt.*;

import static org.testng.Assert.assertEquals;
import static xpath.and.methods.Xpath.*;

public class RegistrationPositive extends Methods {

    @Test(description = "devo-test")
    public static void FutterCheck1Carrier() throws InterruptedException, AWTException {
        ClickButton(ButtonPeople);
        ClickButton(ButtonRegistration);
        // getTXT(FieldRegistration);
        SendKeys(RegistrationUserName, "Мария");
        SendKeys(RegistrationUserSurname, "Волк");
        SendKeys(RegisterUserPhone, "0991966479");
        SendKeys(RegisterUserEmail, "mario@gmail123.com");
        SendKeys(RegisterUserPassword, "Send@123@password");
        WaitLoadPage(2000);
        ClickButton(ButtonSubmit);
        assertEquals(getTXT(PositiveForm), "Підтвердження номера телефону");
        WaitLoadPage(5000);

    }
}