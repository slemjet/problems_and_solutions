package us.slemjet.leetcode.easy.from_551_to_600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReshapeTheMatrixTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 1, 4, new int[][]{new int[]{1, 2, 3, 4}}),
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 2, 4, new int[][]{new int[]{1, 2}, new int[]{3, 4}}),
                Arguments.of(new int[][]{new int[]{1, 2, 3, 4}}, 2, 2, new int[][]{new int[]{1, 2}, new int[]{3, 4}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMatrixReshape(int[][] mat, int r, int c, int[][] expected) {
        // given
        ReshapeTheMatrix solution = new ReshapeTheMatrix();

        // when
        int[][] result = solution.matrixReshape(mat, r, c);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMatrixReshape2(int[][] mat, int r, int c, int[][] expected) {
        // given
        ReshapeTheMatrix solution = new ReshapeTheMatrix();

        // when
        int[][] result = solution.matrixReshape2(mat, r, c);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}