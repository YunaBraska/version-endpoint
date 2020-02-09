package berlin.yuna.versionendpoint.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectVersionResponse {

    private final String projectName;
    private final String projectDescription;
    private final String projectVersion;
    private final Properties git;

    public ProjectVersionResponse(
            final String projectName,
            final String projectDescription,
            final String projectVersion,
            final Properties git) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectVersion = projectVersion;
        this.git = git;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public Properties getGit() {
        return git;
    }
}
