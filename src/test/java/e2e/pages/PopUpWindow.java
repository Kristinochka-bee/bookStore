package e2e.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class PopUpWindow {
    private SelenideElement windowTitle = $x("//div[@id='example-modal-sizes-title-sm']");
    private SelenideElement okButton = $x("//button[@id='closeSmallModal-ok']");
    private SelenideElement cancelButton = $x("//button[@id='closeSmallModal-cancel']");
    private SelenideElement closeButton = $x("//span[@aria-hidden='true']']");

}
