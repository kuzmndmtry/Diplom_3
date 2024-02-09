package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private String success;
    private LoginUserData user;
    private String accessToken;
    private String refreshToken;
    private String message;
}
