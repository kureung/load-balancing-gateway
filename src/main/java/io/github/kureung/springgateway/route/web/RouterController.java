package io.github.kureung.springgateway.route.web;

import io.github.kureung.springgateway.route.application.ConfigRefreshService;
import io.github.kureung.springgateway.route.application.InMemoryRouterGroupRepository;
import io.github.kureung.springgateway.route.application.RouterGroupService;
import io.github.kureung.springgateway.route.model.CustomRouterGroup;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouterController {
    private final RouterGroupService routerGroupService;
    private final ConfigRefreshService configRefreshService;
    private final InMemoryRouterGroupRepository inMemoryRouterGroupRepository;

    public RouterController(final RouterGroupService routerGroupService, final ConfigRefreshService configRefreshService) {
        this.routerGroupService = routerGroupService;
        this.configRefreshService = configRefreshService;
        this.inMemoryRouterGroupRepository = InMemoryRouterGroupRepository.singletonInstance();
    }

    @PostMapping("/routers")
    @ResponseStatus(HttpStatus.CREATED)
    public RouterGroupResponse add(final @RequestBody RouterGroupRequest request) {
        this.routerGroupService.saveRouterGroup(request.routerGroup());
        this.configRefreshService.execute();
        final CustomRouterGroup customRouterGroup = this.inMemoryRouterGroupRepository.routeGroup();
        return RouterGroupResponse.from(customRouterGroup);
    }
}
