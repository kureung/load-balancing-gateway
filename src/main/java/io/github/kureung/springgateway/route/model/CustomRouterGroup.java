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
        verifyRoutes(routes);
        this.name = name;
        this.routes = routes;
    }

    private void verifyRoutes(final List<CustomRouter> routes) {
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
        return name.value();
    }

    public List<CustomRouter> routes() {
        return new ArrayList<>(routes);
    }

    @Override
    public String toString() {
        return "RouteGroup{" +
                "name=" + name.value() +
                ", routes=" + routes +
                '}';
    }
}
