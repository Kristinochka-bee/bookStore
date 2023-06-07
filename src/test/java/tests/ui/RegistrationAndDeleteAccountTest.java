package tests.ui;

import api.RegistrationAndLoginApi;
import api.schema.account.RegistrationDTO;
import com.codeborne.selenide.Condition;
import e2e.pages.LoginPage;
import e2e.pages.PopUpWindow;
import e2e.pages.ProfilePage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;

public class RegistrationAndDeleteAccountTest extends TestBase {
    RegistrationAndLoginApi registrationApi;
    LoginPage loginPage;
    ProfilePage profilePage;

    PopUpWindow popUpWindow;

    @Test
    public void registerNewUserViaApiLoginUIAndDeleteUITest(){
        registrationApi = new RegistrationAndLoginApi();
        RegistrationDTO registrationDTO = registrationApi.randomDataForNewUser();

        Response response = registrationApi.registrationNewUserApi(201, registrationDTO);

        String userName =  response.jsonPath().getString("username");
        String password = registrationApi.randomDataForNewUser().getPassword();

        loginPage = new LoginPage();
        loginPage.login(userName,password);

        profilePage = new ProfilePage();
        profilePage.getUserNameTitle().shouldHave(Condition.text(userName));
        profilePage.getDeleteAccountButton().click();

        popUpWindow = new PopUpWindow();
        popUpWindow.getWindowTitle().shouldBe(Condition.visible);
        popUpWindow.getOkButton().click();

        String expectetAlertText = "User Deleted.";
        String actualAlertText = profilePage.getAlertText();
        Assert.assertEquals(actualAlertText,expectetAlertText);
        profilePage.clickAlertOkButton();


    }

}
