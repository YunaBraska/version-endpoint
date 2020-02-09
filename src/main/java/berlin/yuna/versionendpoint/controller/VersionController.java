package berlin.yuna.versionendpoint.controller;

import berlin.yuna.versionendpoint.service.VersionService;
import berlin.yuna.versionendpoint.model.api.response.ProjectVersionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    private final VersionService versionService;

    VersionController(final VersionService versionService) {
        this.versionService = versionService;
    }

    @GetMapping("/version")
    public ProjectVersionResponse getVersion() {
        return versionService.getVersion();
    }
}
