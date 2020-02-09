package berlin.yuna.versionendpoint.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectVersionResponse {

    private final String projectName;
    private final String projectGroup;
    private final String projectArtifact;
    private final String projectVersion;
    private final Properties git;

    public ProjectVersionResponse(
            final String projectName,
            String projectGroup, final String projectArtifact,
            final String projectVersion,
            final Properties git) {
        this.projectName = projectName;
        this.projectGroup = projectGroup;
        this.projectArtifact = projectArtifact;
        this.projectVersion = projectVersion;
        this.git = git;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectArtifact() {
        return projectArtifact;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public Properties getGit() {
        return git;
    }
}
