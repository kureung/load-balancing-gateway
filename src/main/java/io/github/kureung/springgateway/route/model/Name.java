package io.github.kureung.springgateway.route.model;

import java.util.Objects;
import java.util.UUID;

public final class Name {
    private final String value;

    private Name(final String value) {
        this.value = value;
    }

    public static Name firstInit() {
        final String uuid = UUID.randomUUID().toString();
        return new Name(uuid);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
