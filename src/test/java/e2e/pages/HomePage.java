package e2e.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class HomePage {

    private SelenideElement navigateMenuButton = $x("//button[@class='navbar-toggler']");
    private SelenideElement searchBoxField = $x("//input[@id='searchBox']");
    private SelenideElement searchButton = $x("//span[@id='basic-addon2']");
    private SelenideElement loginButton = $x("//button[@id='login']");

    private SelenideElement logOutButton = $x("//button[@class=\"btn btn-primary\"]");

    private ElementsCollection booksTitles = $$x("//span[@class='mr-2']//a");


    public void searchBookInSearchField(String text){
        searchBoxField.sendKeys();
        searchButton.click();
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public List<String> getTitles(){
        return booksTitles.texts(); // вытащит текст веб элемента и запишет в  список
    }

    public SelenideElement getRandomBook(){
        ElementsCollection books =  $$x("//span[@class='mr-2']//a");
        Random random = new Random();
        int randomIndex = random.nextInt(books.size());  //генерирует рандомную карточку не больше размера нашего массива
        return books.get(randomIndex);
    }



}
