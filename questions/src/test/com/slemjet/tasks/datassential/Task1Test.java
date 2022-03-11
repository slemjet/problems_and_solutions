package com.slemjet.tasks.datassential;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Task1Test {

    public static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(1, 1),
                Arguments.of(1, 1)
        );
    }

    @MethodSource("parameters")
    @ParameterizedTest
    public void testSolution(int n, int expected) {
        // Given
        Task1 solution = new Task1();

        // When
        int result = solution.solution(n);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}