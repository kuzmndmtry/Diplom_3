package api;

import dto.NewUserData;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static pageObject.MainPage.BASE_URI;

public class User {
    private static final String USER_REGISTER = "/api/auth/register"; // эндпоинт для регистрации
    private static final String USER_LOGIN = "/api/auth/login"; // эндпоинт для авторизации
    private static final String USER_LOGOUT = "/api/auth/login"; // эндпоинт для для выхода из системы
    private static final String USER_TOKEN = "/api/auth/token"; // эндпоинт для обновления токена
    private static final String USER_INFO = "/api/auth/user"; // эндпоинт для получения/обновления/удаления данных о пользователе

    @Step("Send POST request to /api/auth/register")
    public Response re(NewUserData newUserData) {
        Response response = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(newUserData)
                .post(USER_REGISTER);
        return response;
    }
    @Step("Send POST request to /api/auth/login")
    public Response sendPostRequestUserLogin(NewUserData newUserData) {
        Response response =
                getDefaultRequestSpecification()
                        .body(userRegisterRequestBody)
                        .post(USER_LOGIN);
        return response;
    }
    @Step("Send DELETE request to /api/auth/user")
    public Response sendDeleteRequestUser(String authorizationToken) {
        Response response =
                (Response) getDefaultRequestSpecification()
                        .header("Authorization", authorizationToken)
                        .delete(USER_INFO);
       USER_INFO return response;
    }
}
