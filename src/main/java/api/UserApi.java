package api;

import dto.NewUserData;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static pageObject.MainPage.BASE_URI;

public class UserApi {
    private static final String USER_REGISTER = "/api/auth/register"; // эндпоинт для регистрации
    private static final String USER_LOGIN = "/api/auth/login"; // эндпоинт для авторизации
    private static final String USER_LOGOUT = "/api/auth/login"; // эндпоинт для для выхода из системы
    private static final String USER_TOKEN = "/api/auth/token"; // эндпоинт для обновления токена
    private static final String USER_INFO = "/api/auth/user"; // эндпоинт для получения/обновления/удаления данных о пользователе

    @Step("Create user(api)")
    public Response createNewUser(NewUserData newUserData) {
        Response response =
                given()
                        .baseUri(BASE_URI)
                        .contentType(ContentType.JSON)
                        .body(newUserData)
                        .post(USER_REGISTER);
        return response;
    }

    @Step("Login user(api)")
    public Response loginUser(NewUserData newUserData) {
        Response response =
                given()
                        .baseUri(BASE_URI)
                        .contentType(ContentType.JSON)
                        .body(newUserData)
                        .post(USER_LOGIN);
        return response;
    }

    @Step("Delete user(api)")
    public Response deleteUser(String authorizationToken) {
        Response response =
                given()
                        .baseUri(BASE_URI)
                        .contentType(ContentType.JSON)
                        .header("Authorization", authorizationToken)
                        .delete(USER_INFO);
      return response;
    }
}
