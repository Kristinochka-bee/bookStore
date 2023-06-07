package tests.api.account;

import api.RegistrationAndLoginApi;
import api.schema.account.RegistrationDTO;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class RegistrationTest extends ApiBase{
    RegistrationAndLoginApi registrationApi;

    @Test
    public void registrationNewUserTest(){
        registrationApi = new RegistrationAndLoginApi();
        RegistrationDTO registrationDTO = registrationApi.randomDataForNewUser();
        Response response = registrationApi.registrationNewUserApi(201, registrationDTO);
    }

}
