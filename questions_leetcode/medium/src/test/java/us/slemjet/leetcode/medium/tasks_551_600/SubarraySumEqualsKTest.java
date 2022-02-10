package us.slemjet.leetcode.medium.tasks_551_600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SubarraySumEqualsKTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1}, 2, 2),
                Arguments.of(new int[]{1, 2, 3}, 3, 2),
                Arguments.of(new int[]{1, -1, 0}, 0, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSubarraySum(int[] nums, int k, int expected) {
        // given
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        // when
        int result = solution.subarraySum(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSubarraySumPrefix(int[] nums, int k, int expected) {
        // given
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        // when
        int result = solution.subarraySumPrefix(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}