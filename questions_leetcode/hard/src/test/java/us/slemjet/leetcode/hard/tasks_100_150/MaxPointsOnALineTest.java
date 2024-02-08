package us.slemjet.leetcode.hard.tasks_100_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxPointsOnALineTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [[1,1],[2,2],[3,3]] -> 3
                Arguments.of(new int[][]{
                        new int[]{1, 1},
                        new int[]{2, 2},
                        new int[]{3, 3}}, 3),
                // [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] -> 4
                Arguments.of(new int[][]{
                        new int[]{1, 1},
                        new int[]{3, 2},
                        new int[]{5, 3},
                        new int[]{4, 1},
                        new int[]{2, 3},
                        new int[]{1, 4}}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxPoints(int[][] points, int expected) {
        // given
        MaxPointsOnALine solution = new MaxPointsOnALine();

        // when
        int result = solution.maxPoints(points);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}