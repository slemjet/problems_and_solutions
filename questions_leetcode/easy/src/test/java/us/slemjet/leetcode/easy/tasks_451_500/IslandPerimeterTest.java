package us.slemjet.leetcode.easy.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IslandPerimeterTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{0, 1, 0, 0},
                        new int[]{1, 1, 1, 0},
                        new int[]{0, 1, 0, 0},
                        new int[]{1, 1, 0, 0}}, 16),
                Arguments.of(new int[][]{
                        new int[]{1}}, 4),
                Arguments.of(new int[][]{
                        new int[]{1, 0}}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] grid, int expected) {
        // given
        IslandPerimeter solution = new IslandPerimeter();

        // when
        int result = solution.islandPerimeter(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}