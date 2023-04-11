package org.example.model.api;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ClearingUser {
    private final String USER_URI = "https://stellarburgers.nomoreparties.site/api/auth";

    private final RequestSpecification spec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(USER_URI)
            .build();

    @Step("Авторизация пользователя")
    public Response loginUser(User user) {
        return given().spec(spec).body(user).post("/login");
    }

    @Step("Удалить пользователя")
    public Response deleteUser(String token) {
        return given().header("authorization", token).spec(spec).when().delete("/user");
    }

}