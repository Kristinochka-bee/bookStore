package tests;

import com.codeborne.selenide.Condition;
import e2e.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddBooksToProfileTest extends TestBase {
    ProfilePage profilePage;
    HomePage homePage;
    BookCard bookCard;
    LoginPage loginPage;
    LeftMenu leftMenu;
    BookPage bookPage;
    String bookTitle;



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

        bookTitle = bookCard.getRandomBook().text(); //вытягиваем текст книги в переменную, но она отличается от названия где мы кликаем по названию книги
        bookCard.getRandomBook().click();
        bookPage = new BookPage();
        bookPage.getAddToYourCollectionButton().shouldBe(Condition.visible);
        bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
        bookPage.getAddToYourCollectionButton().click();

        String expectAlertText = "Book added to your collection.";
        String actualAlertText = bookPage.getAlertText();
        Assert.assertTrue(actualAlertText.contains(expectAlertText));
        bookPage.clickAlertOkButton();

        leftMenu.getProfileMenuButton().click();

        profilePage = new ProfilePage();
        profilePage.getSearchBox().sendKeys(bookTitle);
        profilePage.getTableRows().shouldHave(Condition.text(bookTitle));
        profilePage.getDeleteAllBooksButton().click();
        profilePage.clickAlertOkButton();
        profilePage.clickAlertOkButton();

        /*
        String expectedAlertTexts = "Book deleted.";
        String actualAlertTextss = profilePage.getAlertText();
        Assert.assertTrue(actualAlertTextss.contains(expectedAlertTexts));
        profilePage.clickAlertOkButton();

         */


    }

}
