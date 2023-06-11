package tests.api.bookStore;

import api.enums.EndPoint;
import api.factory.AddListOfBooksFaktory;
import api.factory.LoginViewModelFactory;
import api.schema.account.LoginViewDto;
import api.schema.bookStore.AddBooksDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.api.account.ApiBase;

public class AddBookToProfileTest extends ApiBase {
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewDto loginViewDto = loginViewModelFactory.getObject();

    AddListOfBooksFaktory addListOfBooksFaktory = new AddListOfBooksFaktory();

    AddBooksDto addBooksDto = addListOfBooksFaktory.getObject("9781449325862");
    Response response;

    @BeforeMethod
    public void authorizedTest() {
        response = doPostRequest1(loginViewDto, AUTHORIZED_END_POINT, 200);
        Assert.assertTrue(response.asString().contains("true"));
    }

    @Test
    public void userCanAddBookToProfile(){
        response = doPostRequest1(addBooksDto, "/BookStore/v1/Books", 201);
    }
}
//TODO : тест падает , выдает ошибку : Expected status code <201> but was <504>.
