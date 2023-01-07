package io.github.kureung.springgateway.route.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomRouterGroupTest {
    @Test
    void exception_occurs_when_group_has_route_same_uri() {
        final String url = "http://localhost:8090";
        final CustomRouter router = new CustomRouter(8, url);
        final CustomRouter otherRouter = new CustomRouter(1, url);
        assertThatThrownBy(() -> new CustomRouterGroup(Arrays.asList(router, otherRouter)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("route url must be unique");
    }
}
