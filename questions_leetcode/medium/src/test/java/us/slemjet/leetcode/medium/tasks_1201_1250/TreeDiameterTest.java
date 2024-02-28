package us.slemjet.leetcode.medium.tasks_1201_1250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TreeDiameterTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{0, 1}, new int[]{0, 2}}, 2),
                Arguments.of(new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{1, 4}, new int[]{4, 5}}, 4),
                Arguments.of(new int[][]{}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] edges, int expected) {
        // given
        TreeDiameter solution = new TreeDiameter();

        // when
        int result = solution.treeDiameter(edges);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}