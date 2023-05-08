package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {
    final String BASE_URI = "https://demoqa.com/swagger/";
    final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlJvbiIsInBhc3N3b3JkIjoieUEqVWVldUEycFUzIiwiaWF0IjoxNjgzNTQ0NzU1fQ.cqe_0p_7qCW_aSi7ilRRL5IVmVMf_YAK_vRVBmOVosc";
    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token", API_KEY)
            .build();

    public Response doPostRequest(String endPoint, Integer responseCode, Object body){
        Response resp = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doDeleteRequest(String endPoint, Integer responseCode, int id){
        Response resp = RestAssured.given()
                .spec(spec)
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
                .when()
                .pathParam("id", id)
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doGetRequest(String endPoint, Integer responseCode){
        Response resp = RestAssured.given()
                .spec(spec)
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }

    public Response doPutRequest(String endPoint, Integer responseCode, Object body){
        Response resp = RestAssured.given()
                .spec(spec)
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
