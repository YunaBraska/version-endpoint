package berlin.yuna.versionendpoint.service;

import berlin.yuna.versionendpoint.model.api.response.ProjectVersionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Service
public class VersionService {

    public static final String GIT_PROPERTIES = "classpath:/git.properties";

    private static final Logger LOG = LoggerFactory.getLogger(VersionService.class);

    private final String projectName;
    private final String projectVersion;
    private final String projectDescription;
    private final Properties gitProperties;

    VersionService(@Autowired final ResourceLoader resourceLoader,
                   @Value("${spring.application.name}") final String projectName,
                   @Value("${spring.application.description}") final String projectDescription,
                   @Value("${spring.application.version}") final String projectVersion) throws IOException {

        this.projectName = projectName;
        this.projectVersion = projectVersion;
        this.projectDescription = projectDescription;

        final Resource resource = resourceLoader.getResource(GIT_PROPERTIES);
        gitProperties = new Properties();
        try {
            gitProperties.load(resource.getInputStream());
        } catch (FileNotFoundException e) {
            LOG.error(GIT_PROPERTIES + " file not found. (This file is generated during maven build, e.g. 'mvn clean install')");
        }
    }

    public ProjectVersionResponse getVersion() {
        return new ProjectVersionResponse(projectName, projectDescription, projectVersion, gitProperties);
    }
}
