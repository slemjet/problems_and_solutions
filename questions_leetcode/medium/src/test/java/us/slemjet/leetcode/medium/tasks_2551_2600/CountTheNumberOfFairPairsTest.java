package us.slemjet.leetcode.medium.tasks_2551_2600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountTheNumberOfFairPairsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 7, 4, 4, 5}, 3, 6, 6),
                Arguments.of(new int[]{1, 7, 9, 2, 5}, 11, 11, 1),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, 0, 0, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2Pointers(int[] nums, int lower, int upper, long expected) {
        // given
        CountTheNumberOfFairPairs solution = new CountTheNumberOfFairPairs();

        // when
        long result = solution.countFairPairs2Pointers(nums, lower, upper);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBinarySearch(int[] nums, int lower, int upper, long expected) {
        // given
        CountTheNumberOfFairPairs solution = new CountTheNumberOfFairPairs();

        // when
        long result = solution.countFairPairsBinarySearch(nums, lower, upper);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}