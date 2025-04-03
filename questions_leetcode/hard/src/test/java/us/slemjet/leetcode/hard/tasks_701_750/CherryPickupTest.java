package us.slemjet.leetcode.hard.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CherryPickupTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{0, 1, -1},
                        new int[]{1, 0, -1},
                        new int[]{1, 1, 1}}, 5),
                Arguments.of(new int[][]{
                        new int[]{1, 1, -1},
                        new int[]{1, -1, 1},
                        new int[]{-1, 1, 1}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution3N(int[][] grid, int expected) {
        // given
        CherryPickup solution = new CherryPickup();

        // when
        int value = solution.cherryPickup3N(grid);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution4N(int[][] grid, int expected) {
        // given
        CherryPickup solution = new CherryPickup();

        // when
        int value = solution.cherryPickup4N(grid);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}