package io.github.kureung.springgateway.route.web;

import static java.util.stream.Collectors.toList;

import io.github.kureung.springgateway.route.model.CustomRouter;
import io.github.kureung.springgateway.route.model.CustomRouterGroup;
import java.util.List;

class RouterGroupRequest {
    private List<RouterRequest> routers;

    public RouterGroupRequest() {
    }

    @Override
    public String toString() {
        return "RouterGroupRequest{" +
                "routers=" + this.routers +
                '}';
    }

    private static class RouterRequest {
        private int weight;
        private String url;

        public int getWeight() {
            return this.weight;
        }

        public String getUrl() {
            return this.url;
        }

        private CustomRouter router() {
            return new CustomRouter(this.weight, this.url);
        }

        @Override
        public String toString() {
            return "RouteRequest{" +
                    "weight=" + this.weight +
                    ", url='" + this.url + '\'' +
                    '}';
        }
    }

    public List<RouterRequest> getRouters() {
        return this.routers;
    }

    public CustomRouterGroup routerGroup() {
        return new CustomRouterGroup(this.routers());
    }

    private List<CustomRouter> routers() {
        return this.routers.stream()
                .map(RouterRequest::router)
                .collect(toList());
    }
}
