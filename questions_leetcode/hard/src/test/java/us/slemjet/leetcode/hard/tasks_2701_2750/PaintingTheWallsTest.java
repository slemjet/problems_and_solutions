package us.slemjet.leetcode.hard.tasks_2701_2750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PaintingTheWallsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2}, new int[]{1, 2, 3, 2}, 3),
                Arguments.of(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1}, 4),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}, 1)
                );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopToBottom(int[] cost, int[] time, int expected) {
        // given
        PaintingTheWalls solution = new PaintingTheWalls();

        // when
        int result = solution.paintWallsTopToBottom(cost, time);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(int[] cost, int[] time, int expected) {
        // given
        PaintingTheWalls solution = new PaintingTheWalls();

        // when
        int result = solution.paintWallsBottomUp(cost, time);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}