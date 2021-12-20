package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GameOfLifeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [0,1,0],[0,0,1],[1,1,1],[0,0,0] -> [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
                Arguments.of(new int[][]{
                                new int[]{0, 1, 0},
                                new int[]{0, 0, 1},
                                new int[]{1, 1, 1},
                                new int[]{0, 0, 0}},
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{1, 0, 1},
                                new int[]{0, 1, 1},
                                new int[]{0, 1, 0}}),
                // [[1,1],[1,0]] -> [[1,1],[1,1]]
                Arguments.of(new int[][]{
                                new int[]{1, 1},
                                new int[]{1, 0}},
                        new int[][]{
                                new int[]{1, 1},
                                new int[]{1, 1}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindDuplicate(int[][] board, int[][] expected) {
        // given
        GameOfLife solution = new GameOfLife();

        // when
        solution.gameOfLife(board);

        // then
        Assertions.assertThat(board).isEqualTo(expected);
    }
}