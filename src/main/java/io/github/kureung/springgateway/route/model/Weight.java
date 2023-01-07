package io.github.kureung.springgateway.route.model;

public final class Weight {
    private final int value;

    public Weight(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("weight must be positive");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }
}
