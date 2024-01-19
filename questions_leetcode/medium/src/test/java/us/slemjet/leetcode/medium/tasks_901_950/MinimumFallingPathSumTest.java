package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumFallingPathSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{2, 1, 3}, new int[]{6, 5, 4}, new int[]{7, 8, 9}}, 13),
                Arguments.of(new int[][]{new int[]{-19, 57}, new int[]{-40, -5}}, -59),
                Arguments.of(new int[][]{new int[]{-48}}, -48)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinFallingPathSum(int[][] matrix, int expected) {
        // given
        MinimumFallingPathSum solution = new MinimumFallingPathSum();

        // when
        int result = solution.minFallingPathSum(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinFallingPathSum2(int[][] matrix, int expected) {
        // given
        MinimumFallingPathSum solution = new MinimumFallingPathSum();

        // when
        int result = solution.minFallingPathSum2(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinFallingPathSum3(int[][] matrix, int expected) {
        // given
        MinimumFallingPathSum solution = new MinimumFallingPathSum();

        // when
        int result = solution.minFallingPathSum3(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}