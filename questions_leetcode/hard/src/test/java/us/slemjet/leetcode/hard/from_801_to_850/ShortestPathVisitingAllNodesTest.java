package us.slemjet.leetcode.hard.from_801_to_850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ShortestPathVisitingAllNodesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 2, 3}, new int[]{0}, new int[]{0}, new int[]{0}}, 4),
                Arguments.of(new int[][]{new int[]{1}, new int[]{0, 2, 4}, new int[]{1, 3, 4}, new int[]{2}, new int[]{1, 2}}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testShortestPathLength(int[][] graph, int expected) {
        // given
        ShortestPathVisitingAllNodes solution = new ShortestPathVisitingAllNodes();

        // when
        int value = solution.shortestPathLength(graph);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}