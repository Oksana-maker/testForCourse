package Methdos;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Methods {


    protected static WebDriver driver;

    @BeforeClass//этот метод отработает самым первым
    public static void Connect() {
        try {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();//развертка экрана на фул сайз
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//прекратить загрузку страницы через 20 секунд, 20 можно менять на любое число
            driver.get("https://rozetka.com.ua/ua/");//гипер ссылка нашего сервиса

        } catch (Exception e) {
            System.out.println(e);//покажет ошибку почему не выполнился метод
        }
    }

    public static void IframeClick(String xp) throws InterruptedException {
        driver.switchTo().frame(8);

        waitUntil(xp);
        WebElement element = driver.findElement(By.xpath(xp));
        element.click();

    }

    public static String IframeGetText(String xp) throws InterruptedException {
        driver.switchTo().frame(8);

        WebElement element = driver.findElement(By.xpath(xp));
        String res = element.getText();
        System.out.println(res);
        return res;
    }





    public static void waitUntil(String selector) throws InterruptedException {
        WebElement element = (new WebDriverWait(driver, java.time.Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
//        Thread.sleep(1500);
    }

    public static void ClickButton(String xp) throws InterruptedException {

        waitUntil(xp);
        WebElement element = driver.findElement(By.xpath(xp));
        element.click();
    }

    public static void Assert(String tl, String task){
        String gl = driver.getCurrentUrl();
        Assert.assertEquals(gl,tl,task);
    }
    public static void AssertTXT(String tl, String task){
//        String res =  getTXT(tl);
        Assert.assertEquals(tl,task);
    }

    public static void ScrollToEndPage() throws AWTException {
//        ((JavascriptExecutor) driver).executeScript("100000");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
    }

    public static void WaitLoadPage2S() throws InterruptedException {
        Thread.sleep(2500);
    }

    public static void GoToNewTabBrowser() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
//        System.out.println(driver.getCurrentUrl());
    }

    public static String getTXT(String xp){
        WebElement element = driver.findElement(By.xpath(xp));
        String res = element.getText();
        System.out.println(res);
        return res;
    }

    public static void Navigable(String xp) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xp));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        Thread.sleep(3000);
    }
    public static void NavigableAndClick(String xp, String newBut) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xp));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        Thread.sleep(3000);
//        WebElement element1 = driver.findElement(By.xpath(newBut));
//        actions.click(element1);
    }

    ///////////////////////


    public static void AssertForTxt(String tl, String expected) throws InterruptedException {
        waitUntil(tl);
        WebElement element = driver.findElement(By.xpath(tl));
        Assert.assertEquals(element.getText(),expected);
        System.out.println(element.getText());
    }


//    public static void ScrollToFutter() throws AWTException {
////        ((JavascriptExecutor) driver).executeScript("100000");
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_END);
//    }

    public static void WaitLoadPage(int time) throws InterruptedException {
        Thread.sleep(time);
    }


    public static void SendKeys(String xp, String  txt) throws InterruptedException {
        waitUntil(xp);
        WebElement element = driver.findElement(By.xpath(xp));
        element.click();
        element.sendKeys(txt, Keys.ENTER);

    }

    public static void SendKeysWithoutEnter(String xp, String  txt) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xp));
        waitUntil(xp);
        element.sendKeys(txt);
    }
    public static void SendKeys(String xp, int phone) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xp));
        waitUntil(xp);
        element.sendKeys(String.valueOf(phone), Keys.ENTER);
    }


    public static String randomEmail(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String dom = "@gmail.com";
        String randomEmail = generatedString+dom;
        return randomEmail;
    }

    public static String randomName(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String randomEmail = generatedString;
        return randomEmail;
    }

    public static int RandomPhone(){
        int randomNum = (int)(Math.random() * 101);
        return randomNum;
    }


    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}

