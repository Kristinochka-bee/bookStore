package e2e.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {
    private SelenideElement firstNameField = $x("//input[@id='firstname']");
    private SelenideElement lastNameField = $x("//input[@id='lastname']");
    private SelenideElement userNameField = $x("//input[@id='userName']");
    private SelenideElement passwordField = $x("//input[@id='password']");
    private SelenideElement reCaptcha = $x("(//body)[1]");
    private SelenideElement registerButton = $x("//button[@id='register']");
    private SelenideElement backToLoginButton = $x("//button[@id='gotologin']");


}
