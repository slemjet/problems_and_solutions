package us.slemjet.leetcode.easy.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_50_to_100.MaximumSubarray;

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
    void maxSubArray2(int[] nums, int expected) {
        // given
        MaximumSubarray solution = new MaximumSubarray();

        // when
        double result = solution.maxSubArray2(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
