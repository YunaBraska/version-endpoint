package berlin.yuna.versionendpoint.service;

import berlin.yuna.versionendpoint.model.api.response.ProjectVersionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static java.util.Arrays.asList;
import static org.springframework.util.StringUtils.hasText;

@Service
public class VersionService {

    private static final Logger LOG = LoggerFactory.getLogger(VersionService.class);
    private static final String GIT_PROPERTIES = "classpath:/git.properties";
    private static final String SPLIT_VALUE_PATTERN = "((\\s*,\\s*)|(\\s*;\\s*)|\\s)";

    private final String projectName;
    private final String projectVersion;
    private final String projectGroup;
    private final String projectArtifact;
    private final Map<String, String> gitProperties;

    VersionService(
            @Autowired(required = false) final BuildProperties buildProperties,
            final ResourceLoader resourceLoader,
            @Value("${management.endpoint.version.git.exclude:}") final String exclude,
            @Value("${management.endpoint.version.git.include:*}") final String include
    ) {
        if (buildProperties == null) {
            throw new IllegalStateException("Please run \"mvn compile\" first");
        }
        this.projectName = buildProperties.getName();
        this.projectVersion = buildProperties.getVersion();
        this.projectArtifact = buildProperties.getArtifact();
        this.projectGroup = buildProperties.getGroup();
        this.gitProperties = readGitProperties(resourceLoader.getResource(GIT_PROPERTIES), exclude, include);
    }

    public ProjectVersionResponse getVersion() {
        return new ProjectVersionResponse(projectName, projectGroup, projectArtifact, projectVersion, gitProperties);
    }

    private Map<String, String> readGitProperties(final Resource resource, final String exclude, final String include) {
        final Map<String, String> resultMap = new LinkedHashMap<>();
        try {
            final boolean activeFilter = hasText(include) && !include.trim().equalsIgnoreCase("*");
            if (!exclude.trim().equalsIgnoreCase("*")) {
                final List<String> exclusions = asList(exclude.split(SPLIT_VALUE_PATTERN));
                final List<String> inclusions = asList(include.split(SPLIT_VALUE_PATTERN));
                final Properties p = new Properties();
                p.load(resource.getInputStream());
                p.stringPropertyNames().stream()
                        .filter(n -> !exclusions.contains(toName(n)))
                        .filter(n -> !activeFilter || inclusions.contains(toName(n)))
                        .forEach(n -> resultMap.put(toName(n), p.getProperty(n)));
            } else {
                LOG.debug("All git properties are excluded");
            }
        } catch (IOException e) {
            LOG.error(GIT_PROPERTIES + " file not found. (This file is generated during maven build, e.g. 'mvn clean compile')");
        }
        return resultMap;
    }

    private String toName(final String n) {
        return n.startsWith("git.") ? n.substring(4) : n;
    }
}
