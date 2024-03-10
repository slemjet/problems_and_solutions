package us.slemjet.leetcode.easy.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IntersectionOfTwoArraysTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2}),
                Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{9, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution1(int[] nums1, int[] nums2, int[] expected) {
        // given
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();

        // when
        int[] result = solution.intersectionDictionary(nums1, nums2);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int[] nums1, int[] nums2, int[] expected) {
        // given
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();

        // when
        int[] result = solution.intersectionSort(nums1, nums2);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrder(expected);
    }
}