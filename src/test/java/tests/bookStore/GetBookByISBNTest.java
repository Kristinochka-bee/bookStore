package tests.bookStore;

import api.enums.EndPoint;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.api.account.ApiBase;

import java.util.List;

public class GetBookByISBNTest extends ApiBase {
    Response response;

    @Test
    public void getBookByISBN(){
        response = doGetRequest1("/BookStore/v1/Books", 200,"9781449331818" );
        List<String> books = response.jsonPath().getList("books.title");
        Assert.assertTrue(books.size() > 0);
    }

}


