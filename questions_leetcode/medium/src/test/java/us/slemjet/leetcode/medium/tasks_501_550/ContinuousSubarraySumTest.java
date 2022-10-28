package us.slemjet.leetcode.medium.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ContinuousSubarraySumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{23, 2, 4, 6, 7}, 6, true),
                Arguments.of(new int[]{23, 2, 6, 4, 7}, 6, true),
                Arguments.of(new int[]{23, 2, 6, 4, 7}, 13, false),
                Arguments.of(new int[]{23, 2, 4, 6, 6}, 7, true),
                Arguments.of(new int[]{0, 1}, 2, false),
                Arguments.of(new int[]{1, 0}, 2, false),
                Arguments.of(new int[]{5, 0, 0, 0}, 3, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCheckSubarraySum(int[] nums, int k, boolean expected) {
        // given
        ContinuousSubarraySum solution = new ContinuousSubarraySum();

        // when
        boolean result = solution.checkSubarraySum(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}