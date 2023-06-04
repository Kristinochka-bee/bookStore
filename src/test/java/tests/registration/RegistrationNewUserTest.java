package tests.registration;

import api.RegistrationApi;
import com.codeborne.selenide.Condition;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import tests.TestBase;

public class RegistrationNewUserTest extends TestBase {
    RegistrationApi registrationApi;
    LoginPage loginPage;
    ProfilePage profilePage;



    @Test
    public void registerNewUserViaApiAndLoginViaUITest(){
        registrationApi = new RegistrationApi();
        Response response = registrationApi.registrationNewUserApi(201);

        String userName = response.jsonPath().getString("username");
        String password = registrationApi.randomDataForNewUser().getPassword();

        loginPage = new LoginPage();
        loginPage.login(userName,password);

        profilePage = new ProfilePage();
        profilePage.getUserNameTitle().shouldHave(Condition.text(userName));


    }
}
