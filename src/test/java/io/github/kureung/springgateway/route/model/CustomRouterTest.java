package io.github.kureung.springgateway.route.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomRouterTest {
    @Test
    void it_is_same_route_when_url_of_route_is_same() {
        final String url = "http://localhost:8090";
        final CustomRouter router = new CustomRouter(8, url);
        final CustomRouter otherRouter = new CustomRouter(1, url);
        assertThat(router).isEqualTo(otherRouter);
    }
}
