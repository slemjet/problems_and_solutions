package us.slemjet.leetcode.hard.from_351_to_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BombEnemyTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[][]{
                        new char[]{'0', 'E', '0', '0'},
                        new char[]{'E', '0', 'W', 'E'},
                        new char[]{'0', 'E', '0', '0'}}, 3),
                Arguments.of(new char[][]{
                        new char[]{'W', 'W', 'W'},
                        new char[]{'0', '0', '0'},
                        new char[]{'E', 'E', 'E'}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(char[][] grid, int expected) {
        // given
        BombEnemy solution = new BombEnemy();

        // when
        int result = solution.maxKilledEnemies(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDP(char[][] grid, int expected) {
        // given
        BombEnemy solution = new BombEnemy();

        // when
        int result = solution.maxKilledEnemiesDP(grid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}