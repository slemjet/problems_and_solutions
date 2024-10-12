package us.slemjet.leetcode.hard.tasks_2501_2550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumNumberOfPointsFromGridQueriesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{2, 5, 7},
                                new int[]{3, 5, 1}},
                        new int[]{5, 6, 2}, new int[]{5, 8, 1}
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{5, 2, 1},
                                new int[]{1, 1, 2}},
                        new int[]{3}, new int[]{0}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] grid, int[] queries, int[] expected) {
        // given
        MaximumNumberOfPointsFromGridQueries solution = new MaximumNumberOfPointsFromGridQueries();

        // when
        int[] result = solution.maxPoints(grid, queries);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}