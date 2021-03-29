package us.slemjet.leetcode.easy.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class MergeSortedArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                of(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                of(new int[]{0}, 0, new int[]{1}, 1, new int[]{1}),
                of(new int[]{2, 0}, 1, new int[]{1}, 1, new int[]{1, 2}),
                of(new int[]{4, 0, 0, 0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6}, 5, new int[]{1, 2, 3, 4, 5, 6}),
                of(new int[]{1,2,4,5,6,0}, 5, new int[]{3}, 1, new int[]{1,2,3,4,5,6})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLargestRectangleAreaDynamic(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        // given
        MergeSortedArray solution = new MergeSortedArray();

        // when
        solution.merge(nums1, m, nums2, n);

        // then
        Assertions.assertThat(nums1).isEqualTo(expected);
    }
}
