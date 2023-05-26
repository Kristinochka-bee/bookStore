package e2e.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {

    private SelenideElement loginInBookStoreText = $x("//h5[normalize-space()='Login in Book Store']");
    private SelenideElement userNameField = $x("//input[@id='userName']");
    private SelenideElement passwordField = $x("//input[@id='password']");
    private SelenideElement loginButton = $x("//button[@id='login']");
    private SelenideElement newUserRegistration = $x("//button[@id='newUser']");

    public void login (String userName, String passwordUser){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(passwordUser);
        loginButton.click();
    }

    public void loginToBookStore() {
        userNameField.sendKeys("admin");
        passwordField.sendKeys("Qwerty@12345");
        loginButton.click();
    }

    public void clickOnNewUserRegistrationButton(){
        newUserRegistration.click();
    }


}
