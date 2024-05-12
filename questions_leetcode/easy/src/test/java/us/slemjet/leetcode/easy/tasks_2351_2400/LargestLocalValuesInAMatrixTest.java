package us.slemjet.leetcode.easy.tasks_2351_2400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LargestLocalValuesInAMatrixTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                                new int[]{9, 9, 8, 1},
                                new int[]{5, 6, 2, 6},
                                new int[]{8, 2, 6, 4},
                                new int[]{6, 2, 2, 2}},
                        new int[][]{
                                new int[]{9, 9},
                                new int[]{8, 6}}),
                Arguments.of(new int[][]{
                                new int[]{1, 1, 1, 1, 1},
                                new int[]{1, 1, 1, 1, 1},
                                new int[]{1, 1, 2, 1, 1},
                                new int[]{1, 1, 1, 1, 1},
                                new int[]{1, 1, 1, 1, 1}},
                        new int[][]{
                                new int[]{2, 2, 2},
                                new int[]{2, 2, 2},
                                new int[]{2, 2, 2}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] grid, int[][] expected) {
        // given
        LargestLocalValuesInAMatrix solution = new LargestLocalValuesInAMatrix();

        // when
        int[][] result = solution.largestLocal(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}