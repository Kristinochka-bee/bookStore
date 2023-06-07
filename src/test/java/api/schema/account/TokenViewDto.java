package api.schema.account;

import lombok.Data;

@Data
public class TokenViewDto {
    public String token;
    public String expires;
    public String status;
    public String result;
}
