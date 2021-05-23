package api.services;

import api.asserts.AssertableResponse;

import api.payloads.UserPayload;
import io.qameta.allure.Step;

public class UsersApiService extends ApiService {

    @Step
    public AssertableResponse userCreated(UserPayload userPayload) {
        return new AssertableResponse(
                setupRequestSpec()
                        .body(userPayload)
                        .when()
                        .post("/api/users"));
    }

    @Step
    public AssertableResponse getUsers(String pageNumber) {
        return new AssertableResponse(
                setupRequestSpec()
                        .when()
                        .get("/api/users?page=" + pageNumber));
    }
}