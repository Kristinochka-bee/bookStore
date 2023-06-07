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

    public LoginViewDto getObject(String userName, String password) {
        return LoginViewDto.builder()
                .userName(userName)
                .password(password)
                .build();
    }

}
