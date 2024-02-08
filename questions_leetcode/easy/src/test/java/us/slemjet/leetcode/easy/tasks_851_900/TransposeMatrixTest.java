package us.slemjet.leetcode.easy.tasks_851_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TransposeMatrixTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{4, 5, 6},
                                new int[]{7, 8, 9}},
                        new int[][]{
                                new int[]{1, 4, 7},
                                new int[]{2, 5, 8},
                                new int[]{3, 6, 9}}),
                Arguments.of(
                        new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{4, 5, 6}},
                        new int[][]{
                                new int[]{1, 4},
                                new int[]{2, 5},
                                new int[]{3, 6}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] matrix, int[][] expected) {
        // given
        TransposeMatrix solution = new TransposeMatrix();

        // when
        int[][] result = solution.transpose(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}