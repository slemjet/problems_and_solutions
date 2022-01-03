package us.slemjet.leetcode.easy.from_301_to_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class IntersectionOfTwoArraysIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, Arrays.asList(new int[]{2, 2})),
                Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, Arrays.asList(new int[]{4, 9}, new int[]{9, 4})),
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{1, 1}, Arrays.asList(new int[]{1, 1}))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTopKFrequent(int[] nums1, int[] nums, List<int[]> expected) {
        // given
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();

        // when
        int[] result = solution.intersect(nums1, nums);

        // then
        Assertions.assertThat(expected).containsAnyElementsOf(Collections.singleton(result));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTopKFrequent2Sort(int[] nums1, int[] nums, List<int[]> expected) {
        // given
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();

        // when
        int[] result = solution.intersect2Sort(nums1, nums);

        // then
        Assertions.assertThat(expected).containsAnyElementsOf(Collections.singleton(result));
    }

}