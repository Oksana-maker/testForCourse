package registration;
import Methdos.Methods;
import org.testng.annotations.Test;

import static xpath.and.methods.Xpath.ButtonPeople;

public class TestNewFunction extends Methods{

    @Test(description = "test - form test")
    public static void TestTaskJira777() throws InterruptedException {
        ClickButton(ButtonPeople);
        WaitLoadPage(5000);
    }
}
