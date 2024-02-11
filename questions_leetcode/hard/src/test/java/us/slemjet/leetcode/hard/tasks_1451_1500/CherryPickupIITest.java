package us.slemjet.leetcode.hard.tasks_1451_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CherryPickupIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{3, 1, 1},
                        new int[]{2, 5, 1},
                        new int[]{1, 5, 5},
                        new int[]{2, 1, 1}}, 24),
                Arguments.of(new int[][]{
                        new int[]{1, 0, 0, 0, 0, 0, 1},
                        new int[]{2, 0, 0, 0, 0, 3, 0},
                        new int[]{2, 0, 9, 0, 0, 0, 0},
                        new int[]{0, 3, 0, 5, 4, 0, 0},
                        new int[]{1, 0, 2, 3, 0, 0, 6}}, 28),
                Arguments.of(new int[][]{
                        new int[]{4, 1, 5, 7, 1},
                        new int[]{6, 0, 4, 6, 4},
                        new int[]{0, 9, 6, 3, 5}}, 32)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopToBottom(int[][] grid, int expected) {
        // given
        CherryPickupII solution = new CherryPickupII();

        // when
        int result = solution.cherryPickupTopToBottom(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(int[][] grid, int expected) {
        // given
        CherryPickupII solution = new CherryPickupII();

        // when
        int result = solution.cherryPickupBottomUp(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}