package us.slemjet.leetcode.medium.tasks_2751_2800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestNonDecreasingSubarrayFromTwoArraysTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1}, new int[]{1, 2, 1}, 2),
                Arguments.of(new int[]{1, 3, 2, 1}, new int[]{2, 2, 3, 4}, 4),
                Arguments.of(new int[]{1, 1}, new int[]{2, 2,}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums1, int[] nums2, int expected) {
        // given
        LongestNonDecreasingSubarrayFromTwoArrays solution = new LongestNonDecreasingSubarrayFromTwoArrays();

        // when
        int result = solution.maxNonDecreasingLength(nums1, nums2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}