package io.github.kureung.springgateway.route.application;

import io.github.kureung.springgateway.route.model.CustomRouterGroup;
import org.springframework.stereotype.Service;

@Service
public class RouterGroupService {
    private final InMemoryRouterGroupRepository routerGroupRepository = InMemoryRouterGroupRepository.singletonInstance();

    public void saveRouterGroup(final CustomRouterGroup routerGroup) {
        routerGroupRepository.saveRouterGroup(routerGroup);
    }
}
