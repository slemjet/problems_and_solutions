package us.slemjet.leetcode.medium.tasks_1551_1600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumTimeToMakeRopeColorfulTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abaac", new int[]{1, 2, 3, 4, 5}, 3),
                Arguments.of("abc", new int[]{1, 2, 3}, 0),
                Arguments.of("aabaa", new int[]{1, 2, 3, 4, 1}, 2),
                Arguments.of("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}, 26)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String colors, int[] neededTime, int expected) {
        // given
        MinimumTimeToMakeRopeColorful solution = new MinimumTimeToMakeRopeColorful();

        // when
        int result = solution.minCost(colors, neededTime);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(String colors, int[] neededTime, int expected) {
        // given
        MinimumTimeToMakeRopeColorful solution = new MinimumTimeToMakeRopeColorful();

        // when
        int result = solution.minCost2(colors, neededTime);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}