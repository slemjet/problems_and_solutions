package us.slemjet.leetcode.medium.tasks_751_800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CheapestFlightsWithinKStopsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{1, 3, 600}, new int[]{2, 3, 200}}, 0, 3, 1, 700),
                Arguments.of(3, new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{0, 2, 500}}, 0, 2, 1, 200),
                Arguments.of(3, new int[][]{new int[]{0, 1, 100}, new int[]{1, 2, 100}, new int[]{0, 2, 500}}, 0, 2, 0, 500),
                Arguments.of(5, new int[][]{new int[]{4, 1, 1}, new int[]{1, 2, 3}, new int[]{0, 3, 2}, new int[]{0, 4, 10}, new int[]{3, 1, 1}, new int[]{1, 4, 3}}, 2, 1, 1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int[][] flights, int src, int dst, int k, int expected) {
        // given
        CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();

        // when
        int result = solution.findCheapestPrice(n, flights, src, dst, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}