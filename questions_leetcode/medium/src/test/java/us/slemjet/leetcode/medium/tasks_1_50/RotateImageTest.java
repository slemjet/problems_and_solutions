package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class RotateImageTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{4, 5, 6},
                                new int[]{7, 8, 9}},
                        new int[][]{
                                new int[]{7, 4, 1},
                                new int[]{8, 5, 2},
                                new int[]{9, 6, 3}}
                ),
                of(new int[][]{
                                new int[]{5,  1,  9,  11},
                                new int[]{2,  4,  8,  10},
                                new int[]{13, 3,  6,  7},
                                new int[]{15, 14, 12, 16}},
                        new int[][]{
                                new int[]{15, 13, 2,  5},
                                new int[]{14, 3,  4,  1},
                                new int[]{12, 6,  8,  9},
                                new int[]{16, 7,  10, 11}}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void rotateTest(int[][] matrix, int[][] expected) {
        // given
        RotateImage solution = new RotateImage();

        // when
        solution.rotate(matrix);

        // then
        Assertions.assertThat(matrix).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void rotateMirrorAndSwapTest(int[][] matrix, int[][] expected) {
        // given
        RotateImage solution = new RotateImage();

        // when
        solution.rotateMirrorAndSwap(matrix);

        // then
        Assertions.assertThat(matrix).isEqualTo(expected);
    }
}
