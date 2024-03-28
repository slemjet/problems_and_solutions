package us.slemjet.leetcode.medium.tasks_2951_3000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class LengthOfLongestSubarrayWithAtMostKFrequencyTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2, 6),
                of(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1, 2),
                of(new int[]{5, 5, 5, 5, 5, 5, 5}, 4, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int k, int expected) {
        // given
        LengthOfLongestSubarrayWithAtMostKFrequency solution = new LengthOfLongestSubarrayWithAtMostKFrequency();

        // when
        int result = solution.maxSubarrayLength(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int[] nums, int k, int expected) {
        // given
        LengthOfLongestSubarrayWithAtMostKFrequency solution = new LengthOfLongestSubarrayWithAtMostKFrequency();

        // when
        int result = solution.maxSubarrayLength2(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}