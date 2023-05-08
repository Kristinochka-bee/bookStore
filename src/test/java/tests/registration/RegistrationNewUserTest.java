package tests.registration;

import api.RegistrationApi;
import e2e.pages.LoginPage;
import e2e.pages.ProfilePage;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import tests.TestBase;

public class RegistrationNewUserTest extends TestBase {
    RegistrationApi registrationApi;
    ProfilePage profilePage;
    LoginPage loginPage;

    @Test
    public void registerNewUserViaApiAndLoginViaUITest(){
        registrationApi = new RegistrationApi();
        Response response = registrationApi.registrationNewUserApi(201);

        String userName = response.jsonPath().getString("username");
        String password = registrationApi.randomDataForNewUser().getPassword();

        loginPage = new LoginPage();
        loginPage.login(userName,password);

    }
}
