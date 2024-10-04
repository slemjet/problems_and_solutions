package us.slemjet.leetcode.easy.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindTheCelebrityTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, new int[][]{new int[]{1, 1, 0}, new int[]{0, 1, 0}, new int[]{1, 1, 1}}, 1),
                Arguments.of(3, new int[][]{new int[]{1, 0, 1}, new int[]{1, 1, 0}, new int[]{0, 1, 1}}, -1),
                Arguments.of(2, new int[][]{new int[]{1, 0}, new int[]{1, 1}}, 0),
                Arguments.of(2, new int[][]{new int[]{1, 1}, new int[]{1, 1}}, -1),
                Arguments.of(5, new int[][]{new int[]{1, 1, 1, 0, 0}, new int[]{1, 1, 0, 0, 1},
                        new int[]{0, 0, 1, 0, 1}, new int[]{0, 0, 0, 1, 1}, new int[]{0, 0, 0, 0, 1}}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBrute(int n, int[][] graph, int expected) {
        // given
        FindTheCelebrity.Solution solution = new FindTheCelebrity.Solution(graph);

        // when
        int result = solution.findCelebrityBrute(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int[][] graph, int expected) {
        // given
        FindTheCelebrity.Solution solution = new FindTheCelebrity.Solution(graph);

        // when
        int result = solution.findCelebrity(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}