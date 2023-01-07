package io.github.kureung.springgateway.route.model;

import java.util.Objects;

public final class Url {
    private final String value;

    public Url(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("url_cannot_be_blank_or_empty");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Url url = (Url) o;
        return Objects.equals(value, url.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
