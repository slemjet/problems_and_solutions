package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumPathSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}}, 7),
                Arguments.of(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinPathSum(int[][] grid, int expected) {
        // given
        MinimumPathSum solution = new MinimumPathSum();

        // when
        int result = solution.minPathSum(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinPathSum2(int[][] grid, int expected) {
        // given
        MinimumPathSum solution = new MinimumPathSum();

        // when
        int result = solution.minPathSum2(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}