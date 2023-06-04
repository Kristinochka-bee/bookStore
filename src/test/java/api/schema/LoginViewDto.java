package api.schema;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LoginViewDto {
    private String userName;
    private String password;
}
