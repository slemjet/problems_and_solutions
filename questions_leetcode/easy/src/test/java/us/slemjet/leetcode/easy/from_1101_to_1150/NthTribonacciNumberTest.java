package us.slemjet.leetcode.easy.from_1101_to_1150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_1101_to_1150.NthTribonacciNumber;

import java.util.stream.Stream;

class NthTribonacciNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, 4),
                Arguments.of(25, 1389537),
                Arguments.of(34, 334745777)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTribonacci(int n, int expected) {
        // given
        NthTribonacciNumber solution = new NthTribonacciNumber();

        // when
        int result = solution.tribonacci(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTribonacciMemo(int n, int expected) {
        // given
        NthTribonacciNumber solution = new NthTribonacciNumber();

        // when
        int result = solution.tribonacciMemo(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTribonacciBottomUp(int n, int expected) {
        // given
        NthTribonacciNumber solution = new NthTribonacciNumber();

        // when
        int result = solution.tribonacciBottomUp(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}