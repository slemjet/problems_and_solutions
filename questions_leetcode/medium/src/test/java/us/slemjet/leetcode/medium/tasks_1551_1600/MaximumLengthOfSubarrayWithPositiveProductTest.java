package us.slemjet.leetcode.medium.tasks_1551_1600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumLengthOfSubarrayWithPositiveProductTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, -2, -3, 4}, 4),
                Arguments.of(new int[]{0, 1, -2, -3, -4}, 3),
                Arguments.of(new int[]{-1, -2, -3, 0, 1}, 2),
                Arguments.of(new int[]{-1, 2}, 1),
                Arguments.of(new int[]{-1000000000, -1000000000}, 2),
                Arguments.of(new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2}, 8),
                Arguments.of(new int[]{1, 2, 3, 5, -6, 4, 0, 10}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetMaxLen(int[] nums, int expected) {
        // given
        MaximumLengthOfSubarrayWithPositiveProduct solution = new MaximumLengthOfSubarrayWithPositiveProduct();

        // when
        int result = solution.getMaxLenBottom(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetMaxLenBottomUp(int[] nums, int expected) {
        // given
        MaximumLengthOfSubarrayWithPositiveProduct solution = new MaximumLengthOfSubarrayWithPositiveProduct();

        // when
        int result = solution.getMaxLenBottomUp(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetMaxLenIdx(int[] nums, int expected) {
        // given
        MaximumLengthOfSubarrayWithPositiveProduct solution = new MaximumLengthOfSubarrayWithPositiveProduct();

        // when
        int result = solution.getMaxLenIdx(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}