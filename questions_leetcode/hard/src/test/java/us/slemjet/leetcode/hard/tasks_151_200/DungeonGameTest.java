package us.slemjet.leetcode.hard.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DungeonGameTest {


    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{-2, -3, 3},
                        new int[]{-5, -10, 1},
                        new int[]{10, 30, -5}}, 7),
                Arguments.of(new int[][]{
                        new int[]{0}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] dungeon, int expected) {
        // given
        DungeonGame solution = new DungeonGame();

        // when
        int result = solution.calculateMinimumHP(dungeon);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}