package tests;

import api.ProjectConfig;
import api.conditions.Conditions;
import api.payloads.UserPayload;
import api.responses.UserResponse;
import api.services.UsersApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CreateUserTest {
    private static UsersApiService usersApiService = new UsersApiService();
    private static String name;
    private static String job;

    @BeforeTest
    static void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseURI();
        name = config.name();
        job = config.job();
    }

    @Test
    void testCreateUser() {

        //given
        UserPayload userPayload = new UserPayload()
                .name(name)
                .job(job);
        //expect
        UserResponse response = usersApiService.userCreated(userPayload)
                .expectedResult(Conditions.statusCode(201))
                .expectedResult(Conditions.bodyField("name", equalTo(name)))
                .expectedResult(Conditions.bodyField("job", equalTo(job)))
                .expectedResult(Conditions.bodyField("id", not(emptyString())))
                .expectedResult(Conditions.bodyField("createdAt", not(emptyString())))
                .asPojo(UserResponse.class);
    }
}