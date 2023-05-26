package e2e.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;


@Getter
public class LeftMenu {
    private SelenideElement bookStoreAplicationMenuButton = $x  ("//div[normalize-space()='Book Store Application']");
    private SelenideElement loginMenuButton= $x("//span[normalize-space()='Login']");
    private SelenideElement bookStoreMenuButton = $x("//span[normalize-space()='Book Store']");
    private SelenideElement profileMenuButton = $x("//span[normalize-space()='Profile']");
    private SelenideElement apiBookStoreMenuButton = $x("//span[normalize-space()='Book Store API']");

    public void clickAplicationMenuButton(){
        bookStoreAplicationMenuButton.click();
    }
    public void clickOnbookStoreMenuButton(){
        bookStoreMenuButton.click();
    }

    public String getAlertText() {
        return switchTo().alert().getText();
    }

    public void clickAlertOkButton() {switchTo().alert().accept();}
}
