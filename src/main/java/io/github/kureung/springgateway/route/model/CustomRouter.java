package io.github.kureung.springgateway.route.model;

import java.util.Objects;

public final class CustomRouter {
    private final Weight weight;
    private final Url url;

    public CustomRouter(final int weight, final String uri) {
        this(new Weight(weight), new Url(uri));
    }

    public CustomRouter(final Weight weight, final Url url) {
        this.weight = weight;
        this.url = url;
    }

    public int weight() {
        return weight.value();
    }

    public String url() {
        return url.value();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CustomRouter route = (CustomRouter) o;
        return Objects.equals(url, route.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return "CustomRoute{" +
                "weight=" + weight.value() +
                ", url=" + url.value() +
                '}';
    }
}
