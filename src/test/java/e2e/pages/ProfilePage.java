package e2e.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ProfilePage extends LeftMenu{

    private SelenideElement goToBookStoreButton = $x("//button[@id='gotoStore']");
    private SelenideElement deleteAccountButton = $x("//div[@class='text-center button']//button[@id='submit']");
    private SelenideElement deleteAllBooksButton = $x("//div[@class='text-right button di']//button[@id='submit']");
    private SelenideElement logOutButton = $x("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']");
    private SelenideElement userNameTitle = $x("//label[@id='userName-value']");
    private SelenideElement deleteIcon = $x("//div[@class='rt-tr -odd']//span[@id='']//*[name()='svg']");
    private SelenideElement tableRows = $x("//div[@class=\"rt-tr -padRow -odd\"]");
    private SelenideElement searchBox = $x("//input[@id='searchBox']");

    public void clickOnGoToBookStoreButton(){
        goToBookStoreButton.click();
    }
    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }
    public void clickOnDeleteAllBooksButton(){
        deleteAllBooksButton.click();
    }
    public void clickOnDeleteIcon(){
        deleteIcon.click();
    }



}
