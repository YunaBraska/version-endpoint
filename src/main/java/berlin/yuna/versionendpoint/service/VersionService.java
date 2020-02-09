package berlin.yuna.versionendpoint.service;

import berlin.yuna.versionendpoint.model.api.response.ProjectVersionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class VersionService {

    public static final String GIT_PROPERTIES = "classpath:/git.properties";

    private static final Logger LOG = LoggerFactory.getLogger(VersionService.class);

    private final String projectName;
    private final String projectVersion;
    private final String projectGroup;
    private final String projectArtifact;
    private final Properties gitProperties;

    VersionService(final BuildProperties buildProperties, final ResourceLoader resourceLoader) {
        this.projectName = buildProperties.getName();
        this.projectVersion = buildProperties.getVersion();
        this.projectArtifact = buildProperties.getArtifact();
        this.projectGroup = buildProperties.getGroup();

        final Resource resource = resourceLoader.getResource(GIT_PROPERTIES);
        gitProperties = new Properties();
        try {
            gitProperties.load(resource.getInputStream());
        } catch (IOException e) {
            LOG.error(GIT_PROPERTIES + " file not found. (This file is generated during maven build, e.g. 'mvn clean compile')");
        }
    }

    public ProjectVersionResponse getVersion() {
        return new ProjectVersionResponse(projectName, projectGroup, projectArtifact, projectVersion, gitProperties);
    }
}
