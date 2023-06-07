package api;

import api.enums.EndPoint;
import api.schema.account.LoginViewDto;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import api.schema.account.RegistrationDTO;
import tests.api.account.ApiBase;

public class RegistrationAndLoginApi extends ApiBase {

    RegistrationDTO dto;
    LoginViewDto loginViewDto ;

    EndPoint endPoint;
    Response response;

    Faker faker = new Faker();



    public RegistrationDTO randomDataForNewUser(){
        dto = new RegistrationDTO();
        dto.setUserName(faker.name().username());
        dto.setPassword("yA*UeeuA2pU3");
        return dto;
    }
    public Response registrationNewUserApi(Integer code, RegistrationDTO dto){
        String endpoint = "/Account/v1/User";
        response = doPostRequest(endpoint, code, dto);
        return response;
    }

    public LoginViewDto randomDataForLogin(RegistrationDTO dto){
        loginViewDto = new LoginViewDto();
        loginViewDto.setUserName(dto.getUserName());
        loginViewDto.setPassword(dto.getPassword());
        return loginViewDto;
    }

    public Response loginUserWithRandomData(Integer code, RegistrationDTO dto){
        String endpoint = "/Account/v1/Authorized";
        response = doPostRequest(endpoint, code, randomDataForLogin(dto));
        return response;
    }

}
