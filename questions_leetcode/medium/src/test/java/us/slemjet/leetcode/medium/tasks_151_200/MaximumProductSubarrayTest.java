package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumProductSubarrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, -5, -2, -4, 3}, 24),
                Arguments.of(new int[]{2, 3, -2, 4}, 6),
                Arguments.of(new int[]{-2, 0, -1}, 0),
                Arguments.of(new int[]{-2}, -2),
                Arguments.of(new int[]{1, 2, -3, 4, 0, 1, -2, 3, -4}, 24),
                Arguments.of(new int[]{1, 2, 3, 0, 1, -2, 3, 0, 1, 5, 6, -4, 5, 0, 1, -2, 3, -4}, 30),
                Arguments.of(new int[]{3, -1, 4}, 4),
                Arguments.of(new int[]{-1, -2, -3, 0}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProduct(int[] nums, int expected) {
        // given
        MaximumProductSubarray solution = new MaximumProductSubarray();

        // when
        int result = solution.maxProduct(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProduct1(int[] nums, int expected) {
        // given
        MaximumProductSubarray solution = new MaximumProductSubarray();

        // when
        int result = solution.maxProduct2(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProduct2(int[] nums, int expected) {
        // given
        MaximumProductSubarray solution = new MaximumProductSubarray();

        // when
        int result = solution.maxProduct2(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}