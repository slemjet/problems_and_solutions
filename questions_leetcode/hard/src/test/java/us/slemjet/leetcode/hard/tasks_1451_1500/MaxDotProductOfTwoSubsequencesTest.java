package us.slemjet.leetcode.hard.tasks_1451_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxDotProductOfTwoSubsequencesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}, 18),
                Arguments.of(new int[]{3, -2}, new int[]{2, -6, 7}, 21),
                Arguments.of(new int[]{-1, -1}, new int[]{1, 1}, -1),
                Arguments.of(new int[]{-5,-1,-2}, new int[]{3,3,5,5}, -3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(int[] nums1, int[] nums2, int expected) {
        // given
        MaxDotProductOfTwoSubsequences solution = new MaxDotProductOfTwoSubsequences();

        // when
        int result = solution.maxDotProductBottomUp(nums1, nums2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopToBottom(int[] nums1, int[] nums2, int expected) {
        // given
        MaxDotProductOfTwoSubsequences solution = new MaxDotProductOfTwoSubsequences();

        // when
        int result = solution.maxDotProductTopToBottom(nums1, nums2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}