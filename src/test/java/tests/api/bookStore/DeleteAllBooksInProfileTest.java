package tests.api.bookStore;

import api.factory.LoginViewModelFactory;
import api.schema.account.LoginViewDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.api.account.ApiBase;

public class DeleteAllBooksInProfileTest extends ApiBase {
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewDto loginViewDto = loginViewModelFactory.getObject();
    Response response;

    @BeforeMethod
    public void authorizedTest() {
        response = doPostRequest1(loginViewDto, AUTHORIZED_END_POINT, 200);
        Assert.assertTrue(response.asString().contains("true"));
    }

    @Test
    public void deleteAllBooksInProfile(){
        doDeleteRequest1("/BookStore/v1/Books", 204, "c43bbe0e-8fb7-4d40-9b8b-2a01fa916e69");
    }
}
//TODO : тест падает Invalid number of path parameters. Expected 0, was 1. Redundant path parameters are: id=c43bbe0e-8fb7-4d40-9b8b-2a01fa916e69.
