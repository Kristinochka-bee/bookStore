package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeMethod
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("-remote-allow-origins=*"); //чтоб открывался браузер
        open("https://demoqa.com/login"); //открывает нужную страничку

    }


    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

