package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MinimumHeightTreesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{1, 3}}, List.of(1)),
                Arguments.of(6, new int[][]{new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{3, 4}, new int[]{5, 4}}, List.of(3, 4)),
                Arguments.of(1, new int[][]{}, List.of(0))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int[][] edges, List<Integer> expected) {
        // given
        MinimumHeightTrees solution = new MinimumHeightTrees();

        // when
        List<Integer> result = solution.findMinHeightTrees(n, edges);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}