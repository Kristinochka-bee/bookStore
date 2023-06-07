package tests.api.account;

import api.RegistrationAndLoginApi;
import api.schema.account.RegistrationDTO;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAccountTest extends ApiBase{
    RegistrationAndLoginApi registrationApi;
    String id;


    @BeforeMethod
    public void precondition(){ //create account
        registrationApi = new RegistrationAndLoginApi();
        RegistrationDTO registrationDTO = registrationApi.randomDataForNewUser();
        Response response = registrationApi.registrationNewUserApi(201, registrationDTO);
        id = response.jsonPath().getString("userID"); //достаем id данного аккаунта, кот будем использывать при удалении
       // registrationApi.loginUserWithRandomData(200, registrationDTO);
    }


    @Test
    public void deleteAccountTest(){
        doDeleteRequest1("/Account/v1/User/{id}", 200, id);
    }

}

//TODO пользователь не авторизирован