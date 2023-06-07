package tests.api.account;


import api.factory.LoginViewModelFactory;
import api.schema.account.LoginViewDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizedTest extends ApiBase {
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewDto loginViewDto = loginViewModelFactory.getObject();
    Response response;

    @Test
    public void authorizedTest() {
        response = doPostRequest1(loginViewDto, AUTHORIZED_END_POINT, 200);
        Assert.assertTrue(response.asString().contains("true"));
    }


}
