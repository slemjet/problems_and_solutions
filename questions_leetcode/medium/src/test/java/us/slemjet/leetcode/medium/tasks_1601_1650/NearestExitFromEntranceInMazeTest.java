package us.slemjet.leetcode.medium.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NearestExitFromEntranceInMazeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[][]{new char[]{'+', '+', '.', '+'}, new char[]{'.', '.', '.', '+'}, new char[]{'+', '+', '+', '.'}}, new int[]{1, 2}, 1),
                Arguments.of(new char[][]{new char[]{'+', '+', '+'}, new char[]{'.', '.', '.'}, new char[]{'+', '+', '+'}}, new int[]{1, 0}, 2),
                Arguments.of(new char[][]{new char[]{'.', '+'}}, new int[]{0, 0}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNearestExit(char[][] maze, int[] entrance, int expected) {
        // given
        NearestExitFromEntranceInMaze solution = new NearestExitFromEntranceInMaze();

        // when
        int result = solution.nearestExit(maze, entrance);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}