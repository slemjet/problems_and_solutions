package us.slemjet.leetcode.medium.tasks_2801_2850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumMovesToSpreadStonesOverGridTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 1, 0},
                        new int[]{1, 1, 1},
                        new int[]{1, 2, 1}}, 3),
                Arguments.of(new int[][]{
                        new int[]{1, 3, 0},
                        new int[]{1, 0, 0},
                        new int[]{1, 0, 3}}, 4),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 2},
                        new int[]{1, 1, 0},
                        new int[]{0, 1, 1}}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] grid, int expected) {
        // given
        MinimumMovesToSpreadStonesOverGrid solution = new MinimumMovesToSpreadStonesOverGrid();

        // when
        int result = solution.minimumMoves(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int[][] grid, int expected) {
        // given
        MinimumMovesToSpreadStonesOverGrid solution = new MinimumMovesToSpreadStonesOverGrid();

        // when
        int result = solution.minimumMoves2(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}