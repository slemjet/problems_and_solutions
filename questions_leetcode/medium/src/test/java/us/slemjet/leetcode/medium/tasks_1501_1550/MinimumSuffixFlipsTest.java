package us.slemjet.leetcode.medium.tasks_1501_1550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumSuffixFlipsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of( "10111", 3),
                Arguments.of( "101", 3),
                Arguments.of( "00000", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String target, int expected) {
        // given
        MinimumSuffixFlips solution = new MinimumSuffixFlips();

        // when
        int result = solution.minFlips(target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(String target, int expected) {
        // given
        MinimumSuffixFlips solution = new MinimumSuffixFlips();

        // when
        int result = solution.minFlips2(target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}