package tests.bookStore;

import api.enums.EndPoint;
import api.schema.bookStore.GetAllBooksDto;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.api.account.ApiBase;

import java.util.List;
import java.util.Map;

public class GetAllBooksTest extends ApiBase {
    Response response;

    @Test
    public void getAllBooksTest(){
        response = doGetRequest2(EndPoint.GET_BOOKSTORE_V1_BOOKS, 200);
        List<String> books = response.jsonPath().getList("books.title");
        Assert.assertTrue(books.size() > 0);
    }

}
