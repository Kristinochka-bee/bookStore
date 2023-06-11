package api.schema.bookStore;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AddBooksDto {
    private String userId;
    private String isbn;

}
