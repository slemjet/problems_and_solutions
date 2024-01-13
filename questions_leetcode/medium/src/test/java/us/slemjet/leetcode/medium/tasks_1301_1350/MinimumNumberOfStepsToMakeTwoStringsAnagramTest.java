package us.slemjet.leetcode.medium.tasks_1301_1350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumNumberOfStepsToMakeTwoStringsAnagramTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("bab", "aba", 1),
                Arguments.of("leetcode", "practice", 5),
                Arguments.of("anagram", "mangaar", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, String t, int expected) {
        // given
        MinimumNumberOfStepsToMakeTwoStringsAnagram solution = new MinimumNumberOfStepsToMakeTwoStringsAnagram();

        // when
        int result = solution.minSteps(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionOneArray(String s, String t, int expected) {
        // given
        MinimumNumberOfStepsToMakeTwoStringsAnagram solution = new MinimumNumberOfStepsToMakeTwoStringsAnagram();

        // when
        int result = solution.minStepsOneArray(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}