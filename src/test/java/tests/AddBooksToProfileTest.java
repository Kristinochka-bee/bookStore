package tests;

import com.codeborne.selenide.Condition;
import e2e.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddBooksToProfileTest extends TestBase {
    ProfilePage profilePage;
    HomePage homePage;
    BookCard bookCard;
    LoginPage loginPage;
    LeftMenu leftMenu;

    BookPage bookPage;

    String cardBookTitle;


    @BeforeMethod
    public void precondition(){
        loginPage = new LoginPage();
        loginPage.loginToBookStore();
    }

    @Test
    public void addBooksToProfile()  {

        leftMenu = new LeftMenu();
        leftMenu.clickOnbookStoreMenuButton();

        homePage = new HomePage();
        homePage.getSearchBoxField().shouldBe(Condition.visible);
        bookCard = new BookCard();

        bookCard.getRandomBook().click();
        bookPage = new BookPage();
        bookPage.getAddToYourCollectionButton().shouldBe(Condition.visible);
        bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
        bookPage.getAddToYourCollectionButton().click();

        String expectAlertText = "Book added to your collection.";
        String expectedAlertText2 = "Book already present in the your collection!";
        String actualAlertText = bookPage.getAlertText();
        Assert.assertTrue(actualAlertText.contains(expectAlertText));
        bookPage.clickAlertOkButton();

    }

}
