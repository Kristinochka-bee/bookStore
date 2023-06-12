package tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import e2e.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AddBooksToProfileTest extends TestBase {
    ProfilePage profilePage;
    HomePage homePage;
    //BookCard bookCard;
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
        //bookCard = new BookCard();

        SelenideElement randomBook = homePage.getRandomBook();
        bookTitle = randomBook.text();
        randomBook.click();

        bookPage = new BookPage();
        bookPage.getAddToYourCollectionButton().shouldBe(Condition.visible);
        bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
        bookPage.getAddToYourCollectionButton().click();

        String expectAlertText = "Book added to your collection.";
        String actualAlertText = bookPage.getAlertText();
        Assert.assertEquals(actualAlertText, expectAlertText);

        /*
        String expectAlertText = "Book added to your collection.";
        String actualAlertText = bookPage.getAlertText();

        if (!expectAlertText.equals(actualAlertText)) {
            homePage = new HomePage();
            randomBook = homePage.getRandomBook();
            bookTitle = randomBook.text();
            randomBook.click();

            bookPage.getAddToYourCollectionButton().shouldBe(Condition.visible);
            bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
            bookPage.getAddToYourCollectionButton().click();

            expectAlertText = "Book added to your collection.";
            actualAlertText = bookPage.getAlertText();
        }

        Assert.assertEquals(actualAlertText, expectAlertText);

         */

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

    //TODO: в данном тесте было бы хорошо добавить цикл, что если книга уже присутствует , тогда добавляем другую рандомную книгу
    @Test
    public void addAndDeleteSomeBooksInProfile() {
        homePage = new HomePage();
        bookPage = new BookPage();

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
        profilePage.getYouDontKnowJSBook().shouldBe(Condition.visible);// книги отображаются в таблице
        profilePage.getSpeakingJavaScriptBook().shouldBe(Condition.visible);
        profilePage.getSpeakingJavaScriptBook().isDisplayed();
        profilePage.getSearchBox().sendKeys("You Don't Know JS");
        //profilePage.getTable().shouldHave(Condition.exactText("You Don't Know JS"));
        profilePage.getDeleteIcon().click();

        popUpWindow = new PopUpWindow();
        popUpWindow.getWindowTitle().shouldBe(Condition.visible);
        popUpWindow.getOkButton().click();

        profilePage.getSearchBox().sendKeys("You Don't Know JS");
        profilePage.getTable().shouldBe(Condition.exactText(" ")); // проверкa на то,что книга удалилась

        profilePage.getDeleteAllBooksButton().click(); //удаляем все книги

    }

    @Test
    public void addAndDeleteSomeBooksInProfileCircle() {
        homePage = new HomePage();
        bookPage = new BookPage();

        homePage.getLogOutButton().shouldBe(Condition.visible);

        leftMenu = new LeftMenu();
        leftMenu.clickOnbookStoreMenuButton();

        for (int i = 0; i < homePage.getBooksTitles().size(); i++) {
            if (i == 4 || i == 3 || i == 6) {
                homePage.getBooksTitles().get(i).click();
                bookPage.getAddToYourCollectionButton().click();
                bookPage.clickAlertOkButton();
                bookPage.getBackToBookStoreButton().click();
            }

        }

        leftMenu.getProfileMenuButton().click();
        profilePage = new ProfilePage();
        profilePage.getTableRow().shouldBe(Condition.visible);
        profilePage.getYouDontKnowJSBook().shouldBe(Condition.visible);// книги отображаются в таблице
        profilePage.getSpeakingJavaScriptBook().shouldBe(Condition.visible);
        profilePage.getSpeakingJavaScriptBook().isDisplayed();
        profilePage.getSearchBox().sendKeys("You Don't Know JS");
        //profilePage.getTable().shouldHave(Condition.exactText("You Don't Know JS"));
        profilePage.getDeleteIcon().click();

        popUpWindow = new PopUpWindow();
        popUpWindow.getWindowTitle().shouldBe(Condition.visible);
        popUpWindow.getOkButton().click();

        profilePage.getSearchBox().sendKeys("You Don't Know JS");
        profilePage.getTable().shouldBe(Condition.exactText(" ")); // проверкa на то,что книга удалилась

        profilePage.getDeleteAllBooksButton().click(); //удаляем все книги

    }

    //TODO : книги не добавились в профайл, соответственно проверка на отображение книг в профайле не проходит

    @Test
    public void addAndDeleteSomeBooksInProfileCircle1() {
        homePage = new HomePage();
        bookPage = new BookPage();

        homePage.getLogOutButton().shouldBe(Condition.visible);

        leftMenu = new LeftMenu();
        leftMenu.clickOnbookStoreMenuButton();

        homePage.getSearchBoxField().shouldBe(Condition.visible);

        // Список книг для добавления
        List<String> booksToAdd = Arrays.asList(
                "You Don't Know JS",
                "Speaking JavaScript",
                "Eloquent JavaScript, Second Edition"
        );

        for (String bookTitle : booksToAdd) {
            SelenideElement book = homePage.getBooksTitles().findBy(Condition.exactText(bookTitle));
            String bookHref = book.getAttribute("href");
            book.click();

            bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
            bookPage.getAddToYourCollectionButton().click();
            JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
            js.executeScript("alert('Привет, это алерт!');");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            org.openqa.selenium.Alert alert = getWebDriver().switchTo().alert();
            js.executeScript("arguments[0].accept();", alert);

            //bookPage.clickAlertOkButton();
            bookPage.getBackToBookStoreButton().click();
        }

        leftMenu.getProfileMenuButton().click();
        profilePage = new ProfilePage();
        profilePage.getTableRow().shouldBe(Condition.visible);
        profilePage.getYouDontKnowJSBook().shouldBe(Condition.visible);
        profilePage.getSpeakingJavaScriptBook().shouldBe(Condition.visible);
        profilePage.getSpeakingJavaScriptBook().isDisplayed();
        profilePage.getSearchBox().sendKeys("You Don't Know JS");

        profilePage.getDeleteIcon().click();

        popUpWindow = new PopUpWindow();
        popUpWindow.getWindowTitle().shouldBe(Condition.visible);
        popUpWindow.getOkButton().click();

        profilePage.getSearchBox().sendKeys("You Don't Know JS");
        profilePage.getTable().shouldBe(Condition.exactText(" "));

        profilePage.getDeleteAllBooksButton().click();
    }
}
//TODO: не нажимается кнопка OK аллерт
