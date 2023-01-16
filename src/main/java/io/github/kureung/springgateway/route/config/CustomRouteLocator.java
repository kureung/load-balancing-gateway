package io.github.kureung.springgateway.route.config;

import io.github.kureung.springgateway.route.application.InMemoryRouterGroupRepository;
import io.github.kureung.springgateway.route.model.CustomRouter;
import io.github.kureung.springgateway.route.model.CustomRouterGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import reactor.core.publisher.Flux;

@Slf4j
public final class CustomRouteLocator implements RouteLocator {
    private final RouteLocatorBuilder locatorBuilder;
    private final InMemoryRouterGroupRepository groupRepository;

    public CustomRouteLocator(final RouteLocatorBuilder locatorBuilder, final InMemoryRouterGroupRepository groupRepository) {
        this.locatorBuilder = locatorBuilder;
        this.groupRepository = groupRepository;
    }

    @Override
    public Flux<Route> getRoutes() {
        final CustomRouterGroup customRouterGroup = this.routeGroup();
        log.info("{}", customRouterGroup);
        final RouteLocatorBuilder.Builder routesBuilder = this.locatorBuilder.routes();
        return Flux.fromIterable(customRouterGroup.routers())
                .map(route -> routesBuilder.route(predicateSpec -> CustomRouteLocator.loadBalancingCondition(customRouterGroup.name(), route, predicateSpec)))
                .collectList()
                .flatMapMany(builders -> routesBuilder.build().getRoutes());
    }

    private CustomRouterGroup routeGroup() {
        return this.groupRepository.routeGroup();
    }

    private static Buildable<Route> loadBalancingCondition(final String groupName, final CustomRouter apiRoute,
            final PredicateSpec predicateSpec) {
        return predicateSpec.path("/**")
                .and()
                .weight(groupName, apiRoute.weight())
                .uri(apiRoute.url());
    }
}
