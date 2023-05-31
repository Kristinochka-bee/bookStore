package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    PopUpWindow popUpWindow;
    String bookTitle;



    @BeforeMethod
    public void precondition(){
        loginPage = new LoginPage();
        loginPage.loginToBookStore();
    }

    @Test
    public void addAndDeleteAllBooksInProfile()  {
        homePage = new HomePage();
        homePage.getLogOutButton().shouldBe(Condition.visible);

        leftMenu = new LeftMenu();
        leftMenu.clickOnbookStoreMenuButton();

        homePage.getSearchBoxField().shouldBe(Condition.visible);
        bookCard = new BookCard();

        SelenideElement randomBook = bookCard.getRandomBook();
        bookTitle = randomBook.text();
        randomBook.click();

        bookPage = new BookPage();
        bookPage.getAddToYourCollectionButton().shouldBe(Condition.visible);
        bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
        bookPage.getAddToYourCollectionButton().click();

        String expectAlertText = "Book added to your collection.";
        String actualAlertText = bookPage.getAlertText();
        Assert.assertEquals(actualAlertText, expectAlertText);

        bookPage.clickAlertOkButton();

        leftMenu.getProfileMenuButton().click();

        profilePage = new ProfilePage();
        profilePage.getSearchBox().sendKeys(bookTitle);
        profilePage.getTableRows().getOwnText().contains(bookTitle);// xpath
        profilePage.getDeleteAllBooksButton().click();

        popUpWindow = new PopUpWindow();
        popUpWindow.getWindowTitle().shouldBe(Condition.visible);
        popUpWindow.getOkButton().click();

        profilePage.getSearchBox().sendKeys(bookTitle);
        profilePage.getTableRows().shouldBe(Condition.text(" "));

    }

    @Test
    public void addAndDeleteSomeBooksInProfile(){
        homePage = new HomePage();
        homePage.getLogOutButton().shouldBe(Condition.visible);

        leftMenu = new LeftMenu();
        leftMenu.clickOnbookStoreMenuButton();

        homePage.getSearchBoxField().shouldBe(Condition.visible);
        homePage.getBooksTitles().findBy(Condition.exactText("You Don't Know JS"))
                .shouldHave(Condition.href("/books?book=9781491904244")).click();
        bookPage = new BookPage();
        bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
        bookPage.getAddToYourCollectionButton().click();
        bookPage.clickAlertOkButton();
        bookPage.getBackToBookStoreButton().click();

        homePage.getBooksTitles().findBy(Condition.exactText("Speaking JavaScript"))
                .shouldHave(Condition.href("/books?book=9781449365035")).click();
        bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
        bookPage.getAddToYourCollectionButton().click();
        bookPage.clickAlertOkButton();
        bookPage.getBackToBookStoreButton().click();

        homePage.getBooksTitles().findBy(Condition.exactText("Eloquent JavaScript, Second Edition"))
                .shouldHave(Condition.href("/books?book=9781593275846")).click();
        bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
        bookPage.getAddToYourCollectionButton().click();
        bookPage.clickAlertOkButton();


        leftMenu.getProfileMenuButton().click();
        profilePage = new ProfilePage();
        profilePage.getTableRow().shouldBe(Condition.visible);
        // как сделать проверку на то, что книги отображаются в таблице
        profilePage.getSearchBox().sendKeys("You Don't Know JS");
        profilePage.checkExistingBook(1);

        //как сделать проверку на то,что книга удалилась
        //profilePage.getTableRow().selectOptionContainingText("You Don't Know JS" + "Kyle Simpson" + "O'Reilly Media" );
        // profilePage.getTableRows().shouldBe(Condition.exactText("Speaking JavaScript"));
        // profilePage.getTableRows().shouldBe(Condition.exactText("Eloquent JavaScript, Second Edition"));

        //profilePage.getSearchBox().sendKeys("You Don't Know JS");
        profilePage.getDeleteIcon().click();

        popUpWindow = new PopUpWindow();
        popUpWindow.getWindowTitle().shouldBe(Condition.visible);
        popUpWindow.getOkButton().click();

        profilePage.getSearchBox().sendKeys("You Don't Know JS");

        profilePage.checkExistingBook(0); //как сделать проверку на то,что книга удалилась




    }

}