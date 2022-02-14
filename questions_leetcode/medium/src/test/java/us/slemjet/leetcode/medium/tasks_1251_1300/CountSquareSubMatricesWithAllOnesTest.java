package us.slemjet.leetcode.medium.tasks_1251_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountSquareSubMatricesWithAllOnesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{0, 1, 1, 1},
                        new int[]{1, 1, 1, 1},
                        new int[]{0, 1, 1, 1}}, 15),
                Arguments.of(new int[][]{
                        new int[]{1, 0, 1},
                        new int[]{1, 1, 0},
                        new int[]{1, 1, 0}}, 7),
                Arguments.of(new int[][]{
                        new int[]{0, 0, 0},
                        new int[]{0, 1, 0},
                        new int[]{0, 1, 0},
                        new int[]{1, 1, 1},
                        new int[]{1, 1, 0}}, 8),
                Arguments.of(new int[][]{
                        new int[]{1, 1, 0, 0, 1},
                        new int[]{1, 0, 1, 1, 1},
                        new int[]{1, 1, 1, 1, 1},
                        new int[]{1, 0, 1, 0, 1},
                        new int[]{0, 0, 1, 0, 1}}, 19
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountSquares(int[][] matrix, int expected) {
        // given
        CountSquareSubMatricesWithAllOnes solution = new CountSquareSubMatricesWithAllOnes();

        // when
        int result = solution.countSquares(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountSquaresBottomUp(int[][] matrix, int expected) {
        // given
        CountSquareSubMatricesWithAllOnes solution = new CountSquareSubMatricesWithAllOnes();

        // when
        int result = solution.countSquaresBottomUp(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}