package us.slemjet.leetcode.medium.tasks_1851_1900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountPairsInTwoArraysTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 2, 1}, new int[]{1, 2, 1, 2}, 1),
                Arguments.of(new int[]{1, 10, 6, 2}, new int[]{1, 4, 1, 5}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums1, int[] nums2, long expected) {
        // given
        CountPairsInTwoArrays solution = new CountPairsInTwoArrays();

        // when
        long result = solution.countPairs(nums1, nums2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}