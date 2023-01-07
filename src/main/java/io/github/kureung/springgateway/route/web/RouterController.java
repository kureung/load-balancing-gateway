package io.github.kureung.springgateway.route.web;

import io.github.kureung.springgateway.route.application.ConfigRefreshService;
import io.github.kureung.springgateway.route.application.RouterGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouterController {
    private final RouterGroupService routerGroupService;
    private final ConfigRefreshService configRefreshService;

    public RouterController(final RouterGroupService routerGroupService, final ConfigRefreshService configRefreshService) {
        this.routerGroupService = routerGroupService;
        this.configRefreshService = configRefreshService;
    }

    @PostMapping("/routers")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(final @RequestBody RouterGroupRequest request) {
        routerGroupService.saveRouterGroup(request.routeGroup());
        configRefreshService.execute();
    }
}
