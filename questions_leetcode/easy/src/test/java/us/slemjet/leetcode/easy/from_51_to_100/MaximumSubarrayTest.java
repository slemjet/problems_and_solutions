package us.slemjet.leetcode.easy.from_51_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumSubarrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{-1}, -1),
                Arguments.of(new int[]{Integer.MIN_VALUE}, Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void maxSubArray(int[] nums, int expected) {
        // given
        MaximumSubarray solution = new MaximumSubarray();

        // when
        double result = solution.maxSubArray(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxSubArrayBottomUp(int[] nums, int expected) {
        // given
        MaximumSubarray solution = new MaximumSubarray();

        // when
        double result = solution.maxSubArrayBottomUp(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxSubArrayTopToBottom(int[] nums, int expected) {
        // given
        MaximumSubarray solution = new MaximumSubarray();

        // when
        double result = solution.maxSubArrayTopToBottom(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest

    @MethodSource("parameters")
    void testMaxSubArrayDivideAndConquer(int[] nums, int expected) {
        // given
        MaximumSubarray solution = new MaximumSubarray();

        // when
        double result = solution.maxSubArrayDivideAndConquer(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
