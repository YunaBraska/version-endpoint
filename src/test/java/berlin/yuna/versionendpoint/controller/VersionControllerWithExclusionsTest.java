package berlin.yuna.versionendpoint.controller;

import berlin.yuna.versionendpoint.model.api.response.ProjectVersionResponse;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag("IntegrationTest")
@ActiveProfiles("exclude")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VersionControllerWithExclusionsTest {

    @LocalServerPort
    private int serverPort;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = serverPort;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Autowired
    private BuildProperties buildProperties;

    @Test
    void versionEndpoint_shouldExcludeSomeProperties() {
        final ProjectVersionResponse response = given()
                .log().all()
                .when()
                .get("/internal/version")
                .then()
                .log().all()
                .statusCode(OK.value())
                .contentType(APPLICATION_JSON_VALUE)
                .extract().as(ProjectVersionResponse.class);
        assertThat(response, is(notNullValue()));
        assertThat(response.getProjectName(), is(buildProperties.getName()));
        assertThat(response.getProjectVersion(), is(buildProperties.getVersion()));
        assertThat(response.getProjectGroup(), is(buildProperties.getGroup()));
        assertThat(response.getProjectArtifact(), is(buildProperties.getArtifact()));
        assertThat(response.getGit(), is(notNullValue()));
        assertThat(response.getGit().size(), is(greaterThan(1)));
        assertThat(response.getGit().get("tags"), is(nullValue()));
        assertThat(response.getGit().get("branch"), is(nullValue()));
        assertThat(response.getGit().get("build.version"), is(notNullValue()));
    }

}