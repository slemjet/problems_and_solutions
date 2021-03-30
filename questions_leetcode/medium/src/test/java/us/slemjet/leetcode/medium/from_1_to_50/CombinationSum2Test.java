package us.slemjet.leetcode.medium.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class CombinationSum2Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{10, 1, 2, 7, 6, 1, 5}, 8,
                        asList(
                                asList(1, 7),
                                asList(1, 2, 5),
                                asList(2, 6),
                                asList(1, 1, 6)
                        )),
                Arguments.of(new int[]{2, 5, 2, 1, 2}, 5,
                        asList(
                                asList(1, 2, 2),
                                asList(5)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void combinationSum2(int[] candidates, int target, List<List<Integer>> expected) {
        // given
        CombinationSum2 solution = new CombinationSum2();

        // when
        List<List<Integer>> result = solution.combinationSum2(candidates, target);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}
