package api;

import api.schema.LoginViewDto;
import io.restassured.response.Response;
import tests.api.ApiBase;

public class LoginApi extends ApiBase {
    LoginViewDto dto;
    Response response;
    RegistrationApi registrationApi;

    public LoginViewDto loginDataForUser(){
        dto = new LoginViewDto();
        registrationApi = new RegistrationApi();
        dto.setUserName("admin22");
        dto.setPassword("Qwerty@12345");
        return dto;
    }

    public Response loginUserApi(Integer code){
        String endpoint = "/Account/v1/Authorized";
        response = doPostRequest(endpoint,code,loginDataForUser());
        return response;
    }



}
