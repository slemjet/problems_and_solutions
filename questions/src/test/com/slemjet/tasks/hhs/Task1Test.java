package com.slemjet.tasks.hhs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Task1Test {


    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 5, 5, 1, 0}, 2),
                Arguments.of(new int[]{1, 1, 1, 1}, 1),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 0)

        );
    }

    @MethodSource("params")
    @ParameterizedTest
    public void testSolution(int[] arr, int expected) {
        // Given
        Task1 solution = new Task1();

        // When
        int result = solution.nonUniqueCount(arr);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @MethodSource("params")
    @ParameterizedTest
    public void testSolution2(int[] arr, int expected) {
        // Given
        Task1 solution = new Task1();

        // When
        int result = solution.nonUniqueCount2(arr);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}