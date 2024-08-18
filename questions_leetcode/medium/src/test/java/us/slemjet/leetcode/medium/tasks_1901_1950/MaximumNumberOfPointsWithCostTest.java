package us.slemjet.leetcode.medium.tasks_1901_1950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumNumberOfPointsWithCostTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{1, 5, 1},
                        new int[]{3, 1, 1}}, 9),
                Arguments.of(new int[][]{
                        new int[]{1, 5},
                        new int[]{2, 3},
                        new int[]{4, 2}}, 11),
                Arguments.of(new int[][]{
                        new int[]{0, 3, 0, 4, 2},
                        new int[]{5, 4, 2, 4, 1},
                        new int[]{5, 0, 0, 5, 1},
                        new int[]{2, 0, 1, 0, 3}}, 15),
                Arguments.of(new int[][]{
                        new int[]{5, 2, 1, 2},
                        new int[]{2, 1, 5, 2},
                        new int[]{5, 5, 5, 0}}, 13),
                Arguments.of(new int[][]{
                        new int[]{4, 9, 8, 9, 4, 1, 3, 4},
                        new int[]{3, 5, 2, 4, 0, 8, 2, 4},
                        new int[]{0, 0, 8, 4, 2, 10, 7, 1},
                        new int[]{0, 9, 4, 7, 7, 7, 5, 2},
                        new int[]{0, 4, 7, 1, 1, 6, 7, 1},
                        new int[]{9, 10, 10, 0, 2, 2, 9, 4},
                        new int[]{1, 3, 1, 8, 6, 9, 9, 9},
                        new int[]{3, 8, 6, 7, 7, 4, 9, 6},
                        new int[]{4, 9, 9, 0, 9, 1, 3, 10},
                        new int[]{3, 4, 10, 1, 2, 3, 2, 8}}, 82)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] points, long expected) {
        // given
        MaximumNumberOfPointsWithCost solution = new MaximumNumberOfPointsWithCost();

        // when
        long value = solution.maxPoints(points);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}