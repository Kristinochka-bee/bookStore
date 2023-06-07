package tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import e2e.pages.BookPage;
import e2e.pages.HomePage;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

import e2e.pages.LeftMenu;
import org.testng.annotations.Test;
import tests.TestBase;

public class UserCanOpenBookLinkTest extends TestBase {
    LeftMenu leftMenu;
    HomePage homePage;
    BookPage bookPage;

    String youDontKnowJsLink = "https://github.com/getify/You-Dont-Know-JS/tree/master/es6%20&%20beyond";

    @Test
    public void userCanFollowBookLinkTest(){
        homePage = new HomePage();
        homePage.getLogOutButton().shouldBe(Condition.visible);
        leftMenu = new LeftMenu();
        leftMenu.clickOnbookStoreMenuButton();

        homePage.getSearchBoxField().shouldBe(Condition.visible);
        homePage.getBooksTitles().findBy(Condition.exactText("You Don't Know JS"))
                .shouldHave(Condition.href("/books?book=9781491904244")).click();
        bookPage = new BookPage();
        bookPage.getBackToBookStoreButton().shouldBe(Condition.visible);
        bookPage.getBookLink().shouldBe(Condition.visible);
        bookPage.getBookLink().click();
        switchTo().window(1);     //переход- переключиться на вкладку книги
        webdriver().shouldHave(url(youDontKnowJsLink)); //проверка по URL, что переключились
        Selenide.closeWindow(); //закроет вкладку
        switchTo().window(0);//возврат на предыдущию страницу магазина с индексом 0





    }
}
