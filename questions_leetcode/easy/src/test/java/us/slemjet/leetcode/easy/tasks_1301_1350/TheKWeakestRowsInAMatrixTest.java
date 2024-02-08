package us.slemjet.leetcode.easy.tasks_1301_1350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TheKWeakestRowsInAMatrixTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 1, 0, 0, 0},
                        new int[]{1, 1, 1, 1, 0},
                        new int[]{1, 0, 0, 0, 0},
                        new int[]{1, 1, 0, 0, 0},
                        new int[]{1, 1, 1, 1, 1}}, 3, new int[]{2, 0, 3}),
                Arguments.of(new int[][]{
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 1, 1, 1},
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 0, 0, 0}}, 2, new int[]{0, 2}),
                Arguments.of(new int[][]{
                        new int[]{1, 1, 1, 1, 1},
                        new int[]{1, 0, 0, 0, 0},
                        new int[]{1, 1, 0, 0, 0},
                        new int[]{1, 1, 1, 1, 0},
                        new int[]{1, 1, 1, 1, 1}}, 3, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testKWeakestRows(int[][] mat, int k, int[] expected) {
        // given
        TheKWeakestRowsInAMatrix solution = new TheKWeakestRowsInAMatrix();

        // when
        int[] result = solution.kWeakestRows(mat, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testKWeakestRows2(int[][] mat, int k, int[] expected) {
        // given
        TheKWeakestRowsInAMatrix solution = new TheKWeakestRowsInAMatrix();

        // when
        int[] result = solution.kWeakestRows2(mat, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}