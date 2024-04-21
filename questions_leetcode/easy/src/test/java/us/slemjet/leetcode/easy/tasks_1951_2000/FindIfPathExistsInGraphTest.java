package us.slemjet.leetcode.easy.tasks_1951_2000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindIfPathExistsInGraphTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3,
                        new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}},
                        0, 2, true),
                Arguments.of(6,
                        new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{3, 5}, new int[]{5, 4}, new int[]{4, 3}},
                        0, 5, false),
                Arguments.of(1,
                        new int[][]{},
                        0, 0, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionUnion(int n, int[][] edges, int source, int destination, boolean expected) {
        // given
        FindIfPathExistsInGraph solution = new FindIfPathExistsInGraph();

        // when
        boolean result = solution.validPathUnion(n, edges, source, destination);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBfs(int n, int[][] edges, int source, int destination, boolean expected) {
        // given
        FindIfPathExistsInGraph solution = new FindIfPathExistsInGraph();

        // when
        boolean result = solution.validPathBfs(n, edges, source, destination);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDfs(int n, int[][] edges, int source, int destination, boolean expected) {
        // given
        FindIfPathExistsInGraph solution = new FindIfPathExistsInGraph();

        // when
        boolean result = solution.validPathDfs(n, edges, source, destination);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}