package us.slemjet.leetcode.hard.from_301_to_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestIncreasingPathInAMatrixTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{9, 9, 4},
                        new int[]{6, 6, 8},
                        new int[]{2, 1, 1}}, 4),
                Arguments.of(new int[][]{
                        new int[]{3, 4, 5},
                        new int[]{3, 2, 6},
                        new int[]{2, 2, 1}}, 4),
                Arguments.of(new int[][]{
                        new int[]{1}}, 1),
                Arguments.of(new int[][]{
                        new int[]{2147483647, 1}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestIncreasingPath(int[][] matrix, int expected) {
        // given
        LongestIncreasingPathInAMatrix solution = new LongestIncreasingPathInAMatrix();

        // when
        int result = solution.longestIncreasingPath(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestIncreasingPathTopological(int[][] matrix, int expected) {
        // given
        LongestIncreasingPathInAMatrix solution = new LongestIncreasingPathInAMatrix();

        // when
        int result = solution.longestIncreasingPathTopological(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}