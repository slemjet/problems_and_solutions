package us.slemjet.leetcode.easy.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FibonacciNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFib(int n, int expected) {
        // given
        FibonacciNumber solution = new FibonacciNumber();

        // when
        int result = solution.fib(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFibMemo(int n, int expected) {
        // given
        FibonacciNumber solution = new FibonacciNumber();

        // when
        int result = solution.fibMemo(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFibIter(int n, int expected) {
        // given
        FibonacciNumber solution = new FibonacciNumber();

        // when
        int result = solution.fibIter(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}