package io.github.kureung.springgateway.route.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class UrlTest {
    @ParameterizedTest
    @NullAndEmptySource
    void exception_occurs_when_uri_is_blank_or_empty(final String value) {
        assertThatThrownBy(() ->new Url(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("url cannot be blank or empty");
    }
}
