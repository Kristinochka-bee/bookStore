package api.factory;

import api.schema.account.LoginViewDto;
import api.schema.bookStore.AddBooksDto;

public class AddListOfBooksFaktory implements BookStoreFactory{
    @Override
    public AddBooksDto getObject() {
        return AddBooksDto.builder()
                .userId("df43d6f7-6235-48eb-8630-5cf293931ad2")
                .isbn("9781449331818")
                .build();
    }

    public AddBooksDto getObject(String bookNum) {
        return AddBooksDto.builder()
                .userId("df43d6f7-6235-48eb-8630-5cf293931ad2")
                .isbn(bookNum)
                .build();
    }
}
