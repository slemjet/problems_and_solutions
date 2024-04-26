package us.slemjet.leetcode.hard.tasks_1251_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumFallingPathSumIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}, 13),
                Arguments.of(new int[][]{new int[]{7}}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] grid, int expected) {
        // given
        MinimumFallingPathSumII solution = new MinimumFallingPathSumII();

        // when
        int result = solution.minFallingPathSum(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}