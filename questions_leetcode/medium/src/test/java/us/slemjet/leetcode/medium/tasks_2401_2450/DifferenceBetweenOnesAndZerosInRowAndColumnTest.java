package us.slemjet.leetcode.medium.tasks_2401_2450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DifferenceBetweenOnesAndZerosInRowAndColumnTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{0, 1, 1},
                                new int[]{1, 0, 1},
                                new int[]{0, 0, 1}},
                        new int[][]{
                                new int[]{0, 0, 4},
                                new int[]{0, 0, 4},
                                new int[]{-2, -2, 2}}),
                Arguments.of(
                        new int[][]{
                                new int[]{1, 1, 1},
                                new int[]{1, 1, 1}},
                        new int[][]{
                                new int[]{5, 5, 5},
                                new int[]{5, 5, 5}}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] grid, int[][] expected) {
        // given
        DifferenceBetweenOnesAndZerosInRowAndColumn solution = new DifferenceBetweenOnesAndZerosInRowAndColumn();

        // when
        int[][] result = solution.onesMinusZeros(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}