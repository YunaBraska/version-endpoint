package berlin.yuna.versionendpoint.controller;

import berlin.yuna.versionendpoint.model.api.response.ProjectVersionResponse;
import berlin.yuna.versionendpoint.service.VersionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    private final VersionService versionService;

    VersionController(final VersionService versionService, @Value("${management.endpoint.version.path:/version}") final String endpoint) {
        this.versionService = versionService;
    }

    @GetMapping("${management.endpoint.version.path:/version}")
    public ProjectVersionResponse getVersion() {
        return versionService.getVersion();
    }
}
