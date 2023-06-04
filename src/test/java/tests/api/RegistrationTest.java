package tests.api;

import api.RegistrationApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class RegistrationTest extends ApiBase{
    RegistrationApi registrationApi;

    @Test
    public void registrationNewUserTest(){
        registrationApi = new RegistrationApi();
        Response response = registrationApi.registrationNewUserApi(201);
    }

}
