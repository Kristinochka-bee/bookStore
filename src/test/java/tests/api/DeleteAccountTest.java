package tests.api;

import api.RegistrationApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAccountTest extends ApiBase{
    RegistrationApi registrationApi;
    int id;

    @BeforeMethod
    public void precondition(){ //create account
        registrationApi = new RegistrationApi();
        Response response = registrationApi.registrationNewUserApi(201);
        id = response.jsonPath().getInt("userID"); //достаем id данного аккаунта, кот будем использывать при удалении
    }

    @Test
    public void deleteAccountTest(){
        doDeleteRequest("/Account/v1/User/{UUID}", 200, id);
    }

}

//TODO не удаляется : выдает ошибку "Cannot invoke "java.lang.Integer.intValue()" because the return value of "io.restassured.internal.common.path.ObjectConverter.convertObjectTo(Object, java.lang.Class)" is null"