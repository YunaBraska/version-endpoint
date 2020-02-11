package berlin.yuna.versionendpoint.controller;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ActiveProfiles("path")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VersionControllerWithPropertiesTest {

    @LocalServerPort
    private int serverPort;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = serverPort;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Autowired
    private BuildProperties buildProperties;

    @Test
    public void testVersionEndpoint() {
        given()
                .log().all()
                .when()
                .get("/internal/version")
                .then()
                .log().all()
                .statusCode(OK.value())
                .contentType(APPLICATION_JSON_VALUE)
                .body("projectName", is(buildProperties.getName()))
                .body("projectVersion", is(buildProperties.getVersion()));
    }

}