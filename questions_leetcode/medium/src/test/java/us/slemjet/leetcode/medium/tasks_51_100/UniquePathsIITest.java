package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniquePathsIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 0}}, 2),
                Arguments.of(new int[][]{new int[]{0, 1}, new int[]{0, 0}}, 1),
                Arguments.of(new int[][]{new int[]{0, 0}, new int[]{0, 1}}, 0),
                Arguments.of(new int[][]{new int[]{1}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testUniquePathsWithObstacles(int[][] obstacleGrid, int expected) {
        // given
        UniquePathsII solution = new UniquePathsII();

        // when
        int result = solution.uniquePathsWithObstacles(obstacleGrid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testUniquePathsWithObstacles2(int[][] obstacleGrid, int expected) {
        // given
        UniquePathsII solution = new UniquePathsII();

        // when
        int result = solution.uniquePathsWithObstacles2(obstacleGrid);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}