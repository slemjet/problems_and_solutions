package us.slemjet.leetcode.hard.tasks_801_850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BusRoutesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 2, 7},
                                new int[]{3, 6, 7}}, 1, 6, 2),
                Arguments.of(
                        new int[][]{
                                new int[]{7, 12},
                                new int[]{4, 5, 15},
                                new int[]{6},
                                new int[]{15, 19},
                                new int[]{9, 12, 13}}, 15, 12, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumBusesToDestination(int[][] routes, int source, int target, int expected) {
        // given
        BusRoutes busRoutes = new BusRoutes();

        // when
        int result = busRoutes.numBusesToDestination(routes, source, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}