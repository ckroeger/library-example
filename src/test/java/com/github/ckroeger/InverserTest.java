package com.github.ckroeger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Test different strings by passing the method parameters provided by the @ValueSource annotation")
class InverserTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                arguments("anna", "anna"),
                arguments("February", "yraurbeF")
        );
    }

    @DisplayName("Checks if the reversed string matches with the expected")
    @ParameterizedTest(name = "check if the reverse of ''{0}'' is equal to ''{1}''")
    @MethodSource("testData")
    void reverse(String toReverse, String expected) {
        assertThat(toReverse).isNotBlank();
        assertThat(Inverser.reverse(toReverse)).isEqualTo(expected);
    }
}