package us.slemjet.leetcode.medium.tasks_951_1000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class SnakesAndLaddersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{-1, -1, -1, -1, -1, -1},
                        new int[]{-1, -1, -1, -1, -1, -1},
                        new int[]{-1, -1, -1, -1, -1, -1},
                        new int[]{-1, 35, -1, -1, 13, -1},
                        new int[]{-1, -1, -1, -1, -1, -1},
                        new int[]{-1, 15, -1, -1, -1, -1}}, 4),
                Arguments.of(new int[][]{
                        new int[]{-1, -1},
                        new int[]{-1, 3}}, 1),
                Arguments.of(new int[][]{
                        new int[]{-1, 4, -1},
                        new int[]{6, 2, 6},
                        new int[]{-1, 3, -1}}, 2),
                Arguments.of(new int[][]{
                        new int[]{-1, -1, -1},
                        new int[]{-1, 9, 8},
                        new int[]{-1, 8, 9}}, 1),
                Arguments.of(new int[][]{
                        new int[]{1, 1, -1},
                        new int[]{1, 1, 1},
                        new int[]{-1, 1, 1}}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSnakesAndLadders2(int[][] board, int expected) {
        // given
        SnakesAndLadders solution = new SnakesAndLadders();

        // when
        int result = solution.snakesAndLadders2(board);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}