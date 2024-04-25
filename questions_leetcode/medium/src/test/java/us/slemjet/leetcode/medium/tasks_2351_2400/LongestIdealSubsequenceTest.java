package us.slemjet.leetcode.medium.tasks_2351_2400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestIdealSubsequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("acfgbd", 2, 4),
                Arguments.of("abcd", 3, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopToBottom(String s, int k, int expected) {
        // given
        LongestIdealSubsequence solution = new LongestIdealSubsequence();

        // when
        int result = solution.longestIdealStringTopToBottom(s, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(String s, int k, int expected) {
        // given
        LongestIdealSubsequence solution = new LongestIdealSubsequence();

        // when
        int result = solution.longestIdealStringBottomUp(s, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}