package tests.api.account;

import api.factory.LoginViewModelFactory;
import api.schema.account.LoginViewDto;
import api.schema.account.TokenViewDto;
import io.restassured.response.Response;
import org.apache.commons.lang3.time.DateUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GenerateTokenTest extends ApiBase {
    LoginViewModelFactory loginViewModelFactory = new LoginViewModelFactory();
    LoginViewDto loginViewDto = loginViewModelFactory.getObject();
    TokenViewDto tokenViewDto;
    Response response;

    Date date = DateUtils.addDays(new Date(), 7);
    Date dateTime = DateUtils.addHours(date, -6);

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    String expectedDate = formatter.format(dateTime);


    @Test
    public void generateTokenTest() {
        response = doPostRequest1(loginViewDto, GENERATE_TOKEN_END_POINT, 200);
        tokenViewDto = response.as(TokenViewDto.class);
        Assert.assertNotNull(tokenViewDto.getToken());
        //Assert.assertTrue(tokenViewDto.getExpires().contains(expectedDate));
        Assert.assertEquals(tokenViewDto.getStatus(), "Success");
        Assert.assertEquals(tokenViewDto.getResult(), "User authorized successfully.");
    }


}
// TODO  написать тест к генерация токена