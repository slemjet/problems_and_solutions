package us.slemjet.leetcode.hard.from_1251_to_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ShortestPathInAGridWithObstaclesEliminationTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1}}, 1, 0),
                Arguments.of(new int[][]{
                        new int[]{0}}, 1, 0),
                Arguments.of(new int[][]{
                        new int[]{0, 0, 0},
                        new int[]{1, 1, 0},
                        new int[]{0, 0, 0},
                        new int[]{0, 1, 1},
                        new int[]{0, 0, 0}}, 1, 6),
                Arguments.of(new int[][]{
                        new int[]{0, 1, 1},
                        new int[]{1, 1, 1},
                        new int[]{1, 0, 0}}, 1, -1),
                Arguments.of(new int[][]{
                        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        new int[]{0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                        new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        new int[]{0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                        new int[]{0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
                        new int[]{0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                        new int[]{0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        new int[]{0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 0}}, 1, 21)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testShortestPath(int[][] grid, int k, int expected) {
        // given
        ShortestPathInAGridWithObstaclesElimination solution = new ShortestPathInAGridWithObstaclesElimination();

        // when
        int result = solution.shortestPath(grid, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}