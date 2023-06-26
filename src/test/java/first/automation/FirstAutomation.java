package first.automation;

import Methdos.Methods;
import org.testng.annotations.Test;

import java.awt.*;

import static xpath.and.methods.Xpath.*;

public class FirstAutomation extends Methods {

    @Test(description = "devo-test")
    public static void FirstTestMethod() throws InterruptedException, AWTException {
//        ClickButton(ButtonPeople);
        SendKeys(FieldFind,"Lenovo ThinkBook 16");
        getTXT(GetTxtLenovo);
        WaitLoadPage(7000);
    }
}
