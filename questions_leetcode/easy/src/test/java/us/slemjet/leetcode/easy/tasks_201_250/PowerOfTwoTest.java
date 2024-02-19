package us.slemjet.leetcode.easy.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PowerOfTwoTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(16, true),
                Arguments.of(3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, boolean expected) {
        // given
        PowerOfTwo solution = new PowerOfTwo();

        // when
        boolean result = solution.isPowerOfTwo(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBitCount(int n, boolean expected) {
        // given
        PowerOfTwo solution = new PowerOfTwo();

        // when
        boolean result = solution.isPowerOfTwoBitCount(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionRecursion(int n, boolean expected) {
        // given
        PowerOfTwo solution = new PowerOfTwo();

        // when
        boolean result = solution.isPowerOfTwoRecursion(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionIterative(int n, boolean expected) {
        // given
        PowerOfTwo solution = new PowerOfTwo();

        // when
        boolean result = solution.isPowerOfTwoIterative(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}