package us.slemjet.leetcode.hard.arrays.median_of_two_sorted_arr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

class SolutionTest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 3}, new int[]{2}, 2.0d),
                of(new int[]{1, 2}, new int[]{3, 4}, 2.5d),
                of(new int[]{}, new int[]{2, 3}, 2.5d),
                of(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6}, 4.0d)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums1, int[] nums2, double expected) {
        // given
        Solution solution = new Solution();

        // when
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);

        // then
        Assertions.assertThat(medianSortedArrays).isEqualTo(expected);
    }
}