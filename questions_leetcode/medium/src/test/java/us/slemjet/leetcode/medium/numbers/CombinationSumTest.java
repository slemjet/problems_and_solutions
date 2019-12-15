package us.slemjet.leetcode.medium.numbers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class CombinationSumTest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 6, 7}, 7,
                        asList(
                                asList(7),
                                asList(2, 2, 3))),
                Arguments.of(new int[]{2, 3, 5}, 8,
                        asList(
                                asList(2, 2, 2, 2),
                                asList(2, 3, 3),
                                asList(3, 5))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void combinationSum(int[] candidates, int target, List<List<Integer>> expected) {
        // given
        CombinationSum solution = new CombinationSum();

        // when
        List<List<Integer>> result = solution.combinationSum(candidates, target);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}
