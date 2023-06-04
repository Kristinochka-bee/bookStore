package tests.ui;

import api.LoginApi;
import api.schema.LoginViewDto;
import api.schema.TokenViewDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import tests.api.ApiBase;

public class GenerateTokenTest extends ApiBase {
    TokenViewDto tokenViewDto;
    LoginApi loginApi ;
    Response response;

    @Test
    public void generateTokenTest(){

    }
}
// TODO  написать тест к генерация токена