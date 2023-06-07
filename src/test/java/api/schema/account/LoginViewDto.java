package api.schema.account;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LoginViewDto {
    public String userName;
    public String password;
}
