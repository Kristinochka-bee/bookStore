package e2e.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BookPage extends LeftMenu{

    private SelenideElement addToYourCollectionButton = $x("//div[@class='text-right fullButton']//button[@id='addNewRecordButton']");

    private SelenideElement backToBookStoreButton = $x ("//button[@id='addNewRecordButton']");

    private SelenideElement nameOfBook = $x ("//div[@id='title-wrapper']//label[@id='userName-value']");

    private SelenideElement bookLink = $x("//div[@id='website-wrapper']//label[@id='userName-value']");



}
