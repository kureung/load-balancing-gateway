package io.github.kureung.springgateway.route.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WeightTest {
    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            0
    })
    void exception_occurs_when_weight_is_negative_or_zero(final int value) {
        assertThatThrownBy(() -> new Weight(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("weight must be positive");
    }
}
