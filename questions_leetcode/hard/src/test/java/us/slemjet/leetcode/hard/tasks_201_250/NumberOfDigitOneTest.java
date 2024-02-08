package us.slemjet.leetcode.hard.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfDigitOneTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(13, 6),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        NumberOfDigitOne solution = new NumberOfDigitOne();

        // when
        int result = solution.countDigitOne(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int n, int expected) {
        // given
        NumberOfDigitOne solution = new NumberOfDigitOne();

        // when
        int result = solution.countDigitOne2(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}