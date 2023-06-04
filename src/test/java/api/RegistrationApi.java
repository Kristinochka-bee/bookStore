package api;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import api.schema.RegistrationDTO;
import tests.api.ApiBase;

public class RegistrationApi extends ApiBase {

    RegistrationDTO dto;

    Response response;

    Faker faker = new Faker();

    public RegistrationDTO randomDataForNewUser(){
        dto = new RegistrationDTO();
        dto.setUserName(faker.name().username());
        dto.setPassword("yA*UeeuA2pU3");
        return dto;
    }
    public Response registrationNewUserApi(Integer code){
        String endpoint = "/Account/v1/User";
        response = doPostRequest(endpoint, code, randomDataForNewUser());
        return response;
    }
}
