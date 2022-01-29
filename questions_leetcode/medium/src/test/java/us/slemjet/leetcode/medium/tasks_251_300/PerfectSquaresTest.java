package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PerfectSquaresTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(13, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumSquaresBottomUp(int n, int expected) {
        // given
        PerfectSquares solution = new PerfectSquares();

        // when
        int result = solution.numSquaresBottomUp(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumSquaresTopToBottom(int n, int expected) {
        // given
        PerfectSquares solution = new PerfectSquares();

        // when
        int result = solution.numSquaresTopToBottom(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumSquaresMath(int n, int expected) {
        // given
        PerfectSquares solution = new PerfectSquares();

        // when
        int result = solution.numSquaresMath(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}