package berlin.yuna.versionendpoint.controller;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VersionControllerTest {

    @LocalServerPort
    private int serverPort;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = serverPort;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.application.version}")
    private String projectVersion;

    @Test
    public void testVersionEndpoint() {
        given()
                .auth().basic("user", "password")
                .log().all()
                .when()
                .get("/version")
                .then()
                .log().all()
                .statusCode(OK.value())
                .contentType(MediaType.APPLICATION_JSON_UTF8.toString())
                .body("projectName", is(name))
                .body("projectVersion", is(projectVersion));
    }

}