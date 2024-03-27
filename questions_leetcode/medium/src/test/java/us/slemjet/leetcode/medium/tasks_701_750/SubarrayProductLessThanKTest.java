package us.slemjet.leetcode.medium.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class SubarrayProductLessThanKTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{10, 5, 2, 6}, 100, 8),
                of(new int[]{1, 2, 3}, 0, 0),
                of(new int[]{1, 1, 1}, 2, 6),
                of(new int[]{1, 2, 3, 4, 5}, 1, 0),
                of(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19, 18)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumSubarrayProductLessThanK(int[] nums, int k, int expected) {
        // given
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();

        // when
        int result = solution.numSubarrayProductLessThanK(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}