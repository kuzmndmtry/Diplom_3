package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserData {
    private String success;
    private sdUserData user;
    private String accessToken;
    private String refreshToken;
}
