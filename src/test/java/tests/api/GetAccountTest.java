package tests.api;

import api.LoginApi;
import api.schema.GetAccountByAccountIdDto;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetAccountTest extends ApiBase{
    int id;
    GetAccountByAccountIdDto getAccountByAccountIdDto;
    LoginApi loginApi;
    Response response;

    @BeforeMethod
    public void precondition(){
        loginApi = new LoginApi();
        Response response = loginApi.loginUserApi(200);
        id = response.jsonPath().getInt("userId");
    }
@Test
    public void getAccountByAccountIdTest(){
        doGetRequest("/Account/v1/User/{UUID}",200, id);
}
}
//TODO выдает ошибку : JsonPathException: Failed to parse the JSON document