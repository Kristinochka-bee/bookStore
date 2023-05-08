package e2e.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private SelenideElement navigateMenuButton = $x("//button[@class='navbar-toggler']");
    private SelenideElement searchBoxField = $x("//input[@id='searchBox']");
    private SelenideElement searchButton = $x("//span[@id='basic-addon2']");
    private SelenideElement loginButton = $x("//button[@id='login']");

    public void searchBookInSearchField(String text){
        searchBoxField.sendKeys();
        searchButton.click();
    }

    public void clickLoginButton(){
        loginButton.click();
    }


}
