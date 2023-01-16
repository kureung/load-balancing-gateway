package io.github.kureung.springgateway.route.web;

import io.github.kureung.springgateway.route.model.CustomRouter;
import io.github.kureung.springgateway.route.model.CustomRouterGroup;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RouterGroupResponse {

    private List<RouterResponse> routers;

    public List<RouterResponse> getRouters() {
        return routers;
    }

    public static RouterGroupResponse from(final CustomRouterGroup customRouterGroup) {
        return new RouterGroupResponse(routers(customRouterGroup.routers()));
    }

    private static List<RouterResponse> routers(final List<CustomRouter> customRouters) {
        return customRouters.stream()
                .map(RouterResponse::new)
                .collect(Collectors.toList());
    }

    @Getter
    @NoArgsConstructor
    private static class RouterResponse {
        private String weight;
        private String url;

        private RouterResponse(final CustomRouter customRouter) {
            this.weight = String.valueOf(customRouter.weight());
            this.url = customRouter.url();
        }
    }
}
