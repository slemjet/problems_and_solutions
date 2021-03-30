package us.slemjet.leetcode.medium.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class ThreeSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, asList(asList(-1, 0, 1), asList(-1, -1, 2))),
                Arguments.of(new int[]{0, 0, 0, 0}, asList(asList(0, 0, 0))),
                Arguments.of(new int[]{-1, 0, 1, 0}, asList(asList(-1, 0, 1))),
                Arguments.of(new int[]{-4, -3, -3, -3, -3, 1, 1, 1, 2, 2, 3, 3, 3, 6},
                        asList(asList(-4, 1, 3), asList(-4, 2, 2), asList(-3, -3, 6), asList(-3, 1, 2)))
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
