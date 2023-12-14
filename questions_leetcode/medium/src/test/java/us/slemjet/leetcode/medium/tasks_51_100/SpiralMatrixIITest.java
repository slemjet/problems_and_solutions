package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SpiralMatrixIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3,
                        new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{8, 9, 4},
                                new int[]{7, 6, 5}}),
                Arguments.of(1,
                        new int[][]{
                                new int[]{1}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int[][] expected) {
        // given
        SpiralMatrixII solution = new SpiralMatrixII();

        // when
        int[][] result = solution.generateMatrix(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionSimple(int n, int[][] expected) {
        // given
        SpiralMatrixII solution = new SpiralMatrixII();

        // when
        int[][] result = solution.generateMatrixSimple(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}