package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class FourSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, -1, 0, -2, 2}, 0,
                        asList( asList(-1, 0, 0, 1),
                                asList(-2, -1, 1, 2),
                                asList(-2, 0, 0, 2))),
                Arguments.of(new int[]{0, 0, 0, 0}, 0, asList(asList(0, 0, 0, 0))));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void fourSumTest(int[] nums, int target, List<List<Integer>> expected) {
        // given
        FourSum solution = new FourSum();

        // when
        List<List<Integer>> results = solution.fourSum(nums, target);

        // then
        for (List<Integer> list : results)
            Collections.sort(list);

        for (List<Integer> list : expected)
            Collections.sort(list);

        Assertions.assertThat(results).containsExactlyInAnyOrderElementsOf(expected);
    }
}