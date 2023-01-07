package io.github.kureung.springgateway.route.web;

import io.github.kureung.springgateway.route.model.CustomRouter;
import io.github.kureung.springgateway.route.model.CustomRouterGroup;

import java.util.List;

import static java.util.stream.Collectors.toList;

class RouterGroupRequest {
    private List<RouterRequest> routers;

    private static class RouterRequest {
        private int weight;
        private String url;

        public int getWeight() {
            return weight;
        }

        public String getUrl() {
            return url;
        }

        private CustomRouter router() {
            return new CustomRouter(weight, url);
        }

        @Override
        public String toString() {
            return "RouteRequest{" +
                    "weight=" + weight +
                    ", uri='" + url + '\'' +
                    '}';
        }
    }

    public List<RouterRequest> getRouters() {
        return routers;
    }

    public CustomRouterGroup routeGroup() {
        return new CustomRouterGroup(routes());
    }

    private List<CustomRouter> routes() {
        return routers.stream()
                .map(RouterRequest::router)
                .collect(toList());
    }
}
