package api.factory;

import api.schema.account.LoginViewDto;

public class LoginViewModelFactory implements BookStoreFactory{
    @Override
    public LoginViewDto getObject() {
        return LoginViewDto.builder()
                .userName("admin22")
                .password("Qwerty@12345")
                .build();
    }
//userId "df43d6f7-6235-48eb-8630-5cf293931ad2"
    public LoginViewDto getObject(String userName, String password) {
        return LoginViewDto.builder()
                .userName(userName)
                .password(password)
                .build();
    }

}
