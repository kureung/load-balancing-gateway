package io.github.kureung.springgateway.route.config;

import io.github.kureung.springgateway.route.application.InMemoryRouterGroupRepository;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {
    private final InMemoryRouterGroupRepository routerGroupRepository = InMemoryRouterGroupRepository.singletonInstance();

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder) {
        return new CustomRouteLocator(locatorBuilder, routerGroupRepository);
    }
}
