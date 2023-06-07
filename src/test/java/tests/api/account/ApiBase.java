package tests.api.account;

import api.enums.EndPoint;
import api.factory.LoginViewModelFactory;
import api.schema.account.LoginViewDto;
import api.schema.account.TokenViewDto;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class ApiBase {
    protected Faker faker = new Faker();
    private final String BASE_URL = "https://demoqa.com";
   // final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlJvbiIsInBhc3N3b3JkIjoieUEqVWVldUEycFUzIiwiaWF0IjoxNjgzNTQ0NzU1fQ.cqe_0p_7qCW_aSi7ilRRL5IVmVMf_YAK_vRVBmOVosc";

    protected final String GENERATE_TOKEN_END_POINT = "/Account/v1/GenerateToken";
    String token;
    protected final String  AUTHORIZED_END_POINT = "/Account/v1/Authorized";

    @BeforeMethod
    public void getToken() {
        LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
        LoginViewDto loginViewDto = loginViewModelFactory.getObject("admin22", "Qwerty@12345");
        token = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(loginViewDto)
                .when()
                .log().all()
                .post(GENERATE_TOKEN_END_POINT)
                .then()
                .log().all()
                .extract().response().as(TokenViewDto.class).getToken();
    }

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .build();

    public Response doPostRequest(String endPoint, Integer responseCode, Object body){
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", token)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doPostRequest1(Object body, String endPoint, Integer statusCode) {
        Response resp = given()
                .spec(spec)
                .header("Access-Token", token)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().statusCode(statusCode);
        return resp;
    }

    public Response doDeleteRequest(String endPoint, Integer responseCode, int id){
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", token)
                .when()
                .pathParam("id", id)
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doDeleteRequest1(String endPoint, Integer responseCode, String id){
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", token)
                .when()
                .pathParam("id", id)
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }


    public Response doGetRequestWithParam(String endPoint, Integer responseCode, int id){
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", token)
                .when()
                .pathParam("id", id)
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }


    public Response doGetRequest(String endPoint, Integer responseCode, int id){
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", token)
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doGetRequest1(String endPoint, Integer responseCode, String id){
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", token)
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doGetRequest2(EndPoint endPoint, Integer responseCode) {
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", token)
                .when()
                .log().all()
                .get(endPoint.getValue())
                .then()
                .log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;

    }

    public Response doPutRequest(String endPoint, Integer responseCode, Object body){
        Response resp = RestAssured.given()
                .spec(spec)
                .header("Access-Token", token)
                .body(body)
                .when()
                .log().all()
                .put(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }
}
