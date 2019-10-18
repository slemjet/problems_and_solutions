package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class ThreeSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2))),
                Arguments.of(new int[]{0, 0, 0, 0}, Arrays.asList(Arrays.asList(0, 0, 0))),
                Arguments.of(new int[]{-1, 0, 1, 0},Arrays.asList(Arrays.asList(-1, 0, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void threeSumBrute(int[] nums, List<List<Integer>> expected) {
        // given
        ThreeSum solution = new ThreeSum();

        // when
        List<List<Integer>> results = solution.threeSumBrute(nums);

        // then
        Assertions.assertThat(results).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void threeSumHash(int[] nums, List<List<Integer>> expected) {
        // given
        ThreeSum solution = new ThreeSum();

        // when
        List<List<Integer>> results = solution.threeSumHash(nums);

        // then
        for (List<Integer> list : results)
            Collections.sort(list);

        for (List<Integer> list : expected)
            Collections.sort(list);

        Assertions.assertThat(results).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void threeSum2Pointers(int[] nums, List<List<Integer>> expected) {
        // given
        ThreeSum solution = new ThreeSum();

        // when
        List<List<Integer>> results = solution.threeSum2Pointers(nums);

        // then
        for (List<Integer> list : results)
            Collections.sort(list);

        for (List<Integer> list : expected)
            Collections.sort(list);

        Assertions.assertThat(results).containsExactlyInAnyOrderElementsOf(expected);
    }
}