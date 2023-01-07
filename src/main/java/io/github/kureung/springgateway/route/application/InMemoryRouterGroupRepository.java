package io.github.kureung.springgateway.route.application;

import io.github.kureung.springgateway.route.model.CustomRouter;
import io.github.kureung.springgateway.route.model.CustomRouterGroup;

import java.util.Arrays;

public class InMemoryRouterGroupRepository {
    private CustomRouterGroup routerGroup = temporaryRouteGroupForFirstInit();

    public static InMemoryRouterGroupRepository singletonInstance() {
        return InMemoryHolder.INSTANCE;
    }

    private static class InMemoryHolder {
        private static final InMemoryRouterGroupRepository INSTANCE = new InMemoryRouterGroupRepository();
    }

    private InMemoryRouterGroupRepository() {
    }

    private CustomRouterGroup temporaryRouteGroupForFirstInit() {
        final CustomRouter router = new CustomRouter(9, "http://localhost:8090");
        final CustomRouter otherRouter = new CustomRouter(1, "http://localhost:8070");
        return new CustomRouterGroup(Arrays.asList(router, otherRouter));
    }

    public CustomRouterGroup routeGroup() {
        return routerGroup;
    }

    public void saveRouterGroup(final CustomRouterGroup customRouterGroup) {
        routerGroup = customRouterGroup;
    }
}
