package us.slemjet.leetcode.hard.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumbersWithRepeatedDigitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(20, 1),
                Arguments.of(100, 10),
                Arguments.of(1000, 262)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        NumbersWithRepeatedDigits solution = new NumbersWithRepeatedDigits();

        // when
        long result = solution.numDupDigitsAtMostN(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}