package tests;

import api.ProjectConfig;
import api.conditions.Conditions;
import api.responses.*;
import api.services.UsersApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetUsersTest {
    private static UsersApiService usersApiService = new UsersApiService();
    private static String pageNumber;

    @BeforeTest
    static void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseURI();
        pageNumber = config.pageNumber();
    }

    @Test
    void testGetUsers() {
        //expect
        UsersResponse response = usersApiService.getUsers(pageNumber)
                .expectedResult(Conditions.statusCode(200))
                .expectedResult(Conditions.bodyField("page", notNullValue()))
                .expectedResult(Conditions.bodyField("per_page", notNullValue()))
                .expectedResult(Conditions.bodyField("total", notNullValue()))
                .expectedResult(Conditions.bodyField("total_pages", notNullValue()))
                .expectedResult(Conditions.bodyField("data", notNullValue()))
                .expectedResult(Conditions.bodyField("support", notNullValue()))
                .expectedResult(Conditions.bodyField("support", hasEntry("url", "https://reqres.in/#support-heading")))
                .expectedResult(Conditions.bodyField("support", hasEntry("text", "To keep ReqRes free, contributions towards server costs are appreciated!")))

                .asPojo(UsersResponse.class);
    }
}