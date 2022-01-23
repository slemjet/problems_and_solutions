package us.slemjet.leetcode.medium.tasks_1301_1350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MatrixBlockSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{4, 5, 6},
                                new int[]{7, 8, 9}}, 1,
                        new int[][]{
                                new int[]{12, 21, 16},
                                new int[]{27, 45, 33},
                                new int[]{24, 39, 28}}),
                Arguments.of(new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{4, 5, 6},
                                new int[]{7, 8, 9}}, 2,
                        new int[][]{
                                new int[]{45, 45, 45},
                                new int[]{45, 45, 45},
                                new int[]{45, 45, 45}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMatrixBlockSum(int[][] mat, int k, int[][] expected) {
        // given
        MatrixBlockSum solution = new MatrixBlockSum();

        // when
        int[][] result = solution.matrixBlockSum(mat, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}