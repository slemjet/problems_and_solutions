package us.slemjet.leetcode.hard.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindKthSmallestPairDistanceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 1}, 1, 0),
                Arguments.of(new int[]{1, 1, 1}, 2, 0),
                Arguments.of(new int[]{1, 6, 1}, 3, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBucket(int[] nums, int k, int expected) {
        // given
        FindKthSmallestPairDistance solution = new FindKthSmallestPairDistance();

        // when
        int value = solution.smallestDistancePairBucket(nums, k);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2Pointer(int[] nums, int k, int expected) {
        // given
        FindKthSmallestPairDistance solution = new FindKthSmallestPairDistance();

        // when
        int value = solution.smallestDistancePair2Pointer(nums, k);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}