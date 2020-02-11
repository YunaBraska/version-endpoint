package berlin.yuna.versionendpoint.model.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectVersionResponse {

    private final String projectName;
    private final String projectGroup;
    private final String projectArtifact;
    private final String projectVersion;
    private final Map<String, String> git;

    public ProjectVersionResponse() {
        this(null, null, null, null, null);
    }

    public ProjectVersionResponse(
            final String projectName,
            final String projectGroup,
            final String projectArtifact,
            final String projectVersion,
            final Map<String, String> git) {
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

    public String getProjectGroup() {
        return projectGroup;
    }

    public Map<String, String> getGit() {
        return git;
    }
}
