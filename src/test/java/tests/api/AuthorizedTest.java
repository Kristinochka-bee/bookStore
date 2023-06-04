package tests.api;

import api.LoginApi;
import api.schema.LoginViewDto;
import org.testng.annotations.Test;

public class AuthorizedTest extends ApiBase {
    LoginApi loginApi;

    @Test
    public void userAuthorization(){
        loginApi = new LoginApi();
        loginApi.loginUserApi(200);
    }
}
