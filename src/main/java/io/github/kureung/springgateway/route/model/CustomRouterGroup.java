package io.github.kureung.springgateway.route.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CustomRouterGroup {
    private final Name name;
    private final List<CustomRouter> routes;

    public CustomRouterGroup(final List<CustomRouter> routes) {
        this(Name.firstInit(), routes);
    }

    private CustomRouterGroup(final Name name, final List<CustomRouter> routes) {
        CustomRouterGroup.verifyRoutes(routes);
        this.name = name;
        this.routes = routes;
    }

    private static void verifyRoutes(final List<CustomRouter> routes) {
        if (routes == null) {
            throw new IllegalArgumentException("routes must not be null");
        }

        if (routes.isEmpty()) {
            throw new IllegalArgumentException("routes must not be empty");
        }

        if (routes.size() != new HashSet<>(routes).size()) {
            throw new IllegalArgumentException("route url must be unique");
        }
    }

    public String name() {
        return this.name.value();
    }

    public List<CustomRouter> routers() {
        return new ArrayList<>(this.routes);
    }

    @Override
    public String toString() {
        return "RouteGroup{" +
                "name=" + this.name.value() +
                ", routes=" + this.routes +
                '}';
    }
}
