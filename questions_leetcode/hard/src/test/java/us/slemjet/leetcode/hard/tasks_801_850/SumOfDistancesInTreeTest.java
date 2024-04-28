package us.slemjet.leetcode.hard.tasks_801_850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumOfDistancesInTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(6, new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4}, new int[]{2, 5}}, new int[]{8, 12, 6, 10, 10, 10}),
                Arguments.of(1, new int[][]{}, new int[]{0}),
                Arguments.of(2, new int[][]{new int[]{1, 0}}, new int[]{1, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int[][] edges, int[] expected) {
        // given
        SumOfDistancesInTree solution = new SumOfDistancesInTree();

        // when
        int[] result = solution.sumOfDistancesInTree(n, edges);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}