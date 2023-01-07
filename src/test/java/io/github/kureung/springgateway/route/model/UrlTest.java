package io.github.kureung.springgateway.route.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UrlTest {
    @ParameterizedTest
    @NullAndEmptySource
    void exception_occurs_when_uri_is_blank_or_empty(final String value) {
        assertThatThrownBy(() ->new Url(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("url_cannot_be_blank_or_empty");
    }
}
