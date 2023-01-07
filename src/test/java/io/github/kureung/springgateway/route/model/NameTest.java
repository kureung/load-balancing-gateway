package io.github.kureung.springgateway.route.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {
    @Test
    void name_is_always_different_from_each_other() {
        final Name name = Name.firstInit();
        final Name otherName = Name.firstInit();
        assertThat(name).isNotEqualTo(otherName);
    }
}
