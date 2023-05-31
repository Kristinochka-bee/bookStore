package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase {
    @BeforeMethod
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("-remote-allow-origins=*"); //чтоб открывался браузер
        open("https://demoqa.com/login"); //открывает нужную страничку
        getWebDriver().manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920,1780)); //задать параметры окну браузера

        //JavascriptExecutor js = (JavascriptExecutor) getWebDriver(); // объявляем JavaExicutor
    }


    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

