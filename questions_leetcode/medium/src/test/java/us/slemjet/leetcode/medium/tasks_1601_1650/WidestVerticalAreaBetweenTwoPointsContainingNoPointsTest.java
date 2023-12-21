package us.slemjet.leetcode.medium.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WidestVerticalAreaBetweenTwoPointsContainingNoPointsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{8, 7},
                        new int[]{9, 9},
                        new int[]{7, 4},
                        new int[]{9, 7}}, 1),
                Arguments.of(new int[][]{
                        new int[]{3, 1},
                        new int[]{9, 0},
                        new int[]{1, 0},
                        new int[]{1, 4},
                        new int[]{5, 3},
                        new int[]{8, 8}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] points, int expected) {
        // given
        WidestVerticalAreaBetweenTwoPointsContainingNoPoints solution = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();

        // when
        int result = solution.maxWidthOfVerticalArea(points);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}