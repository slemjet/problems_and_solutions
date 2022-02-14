package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumSizeSubarraySumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(7, new int[]{2, 3, 1, 2, 4, 3}, 2),
                Arguments.of(4, new int[]{1, 4, 4}, 1),
                Arguments.of(11, new int[]{1, 2, 3, 4, 5}, 3),
                Arguments.of(15, new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinSubArrayLen2Pointers(int target, int[] nums, int expected) {
        // given
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();

        // when
        int result = solution.minSubArrayLen2Pointers(target, nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinSubArrayLenSort(int target, int[] nums, int expected) {
        // given
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();

        // when
        int result = solution.minSubArrayLenSort(target, nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}