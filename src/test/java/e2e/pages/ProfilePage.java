package e2e.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ProfilePage extends LeftMenu{

    private SelenideElement goToBookStoreButton = $x("//button[@id='gotoStore']");
    private SelenideElement deleteAccountButton = $x("//div[@class='text-center button']//button[@id='submit']");
    private SelenideElement deleteAllBooksButton = $x("//div[@class='text-right button di']//button[@id='submit']");
    private SelenideElement logOutButton = $x("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']");
    private SelenideElement userNameTitle = $x("//label[@id='userName-value']");
    private SelenideElement deleteIcon = $x("//span[@id='delete-record-undefined']");
    private SelenideElement tableRows = $x("//div[@class=\"rt-tr -padRow -odd\"]");
    private SelenideElement searchBox = $x("//input[@id='searchBox']");
    private SelenideElement tableRow = $x("//div[@class='rt-tr -odd']");
    private SelenideElement table = $x("//div[@class='rt-tbody']//div[1]//div[1]//div[2]");
    private ElementsCollection tableRowsss = $$x ("//*[@class=\"rt-tr-group\"]");

    private SelenideElement youDontKnowJSBook = $x("//span[@id=\"see-book-You Don't Know JS\"]");
    private SelenideElement speakingJavaScriptBook = $x("//span[@id=\"see-book-Speaking JavaScript\"]");
    private SelenideElement eloquentJavaScriptSecondEditionBook = $x("//span[@id=\"see-book-Eloquent JavaScript, Second Edition\"]");



    public void checkExistingBook(Number expectedCountRow) {
        ElementsCollection actualCountRow = $$x ("//div[@class=\"rt-td\"]//span[@class=\"mr-2\"]");
        Assert.assertEquals(actualCountRow, expectedCountRow);
    }

}
