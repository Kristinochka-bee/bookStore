package tests.api.account;

import api.RegistrationAndLoginApi;
import api.schema.account.GetAccountByAccountIdDto;
import api.schema.account.RegistrationDTO;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetAccountTest extends ApiBase{
    RegistrationAndLoginApi registrationApi;
    String id;
    GetAccountByAccountIdDto getAccountByAccountIdDto;
    Response response;

    @BeforeMethod
    public void precondition(){
        registrationApi = new RegistrationAndLoginApi();
        RegistrationDTO registrationDTO = registrationApi.randomDataForNewUser();
        Response response = registrationApi.registrationNewUserApi(201, registrationDTO);
        id = response.jsonPath().getString("df43d6f7-6235-48eb-8630-5cf293931ad2");
    }
@Test
    public void getAccountByAccountIdTest(){
        doGetRequest1("/Account/v1/User/{id}",200, id);
}
}
//TODO выдает ошибку : Invalid number of path parameters. Expected 1, was 0. Undefined path parameters are: id.