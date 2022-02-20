package us.slemjet.leetcode.medium.tasks_1251_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class RemoveCoveredIntervalsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[][]{new int[]{1, 4}, new int[]{3, 6}, new int[]{2, 8}}, 2),
                of(new int[][]{new int[]{1, 4}, new int[]{2, 3}}, 1),
                of(new int[][]{new int[]{1, 2}, new int[]{1, 4}, new int[]{3, 4}}, 1),
                of(new int[][]{new int[]{1, 4}, new int[]{4, 7}, new int[]{3, 6}}, 3),
                of(new int[][]{new int[]{0, 10}, new int[]{1, 15}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveCoveredIntervals(int[][] intervals, int expected) {
        // given
        RemoveCoveredIntervals solution = new RemoveCoveredIntervals();

        // when
        int result = solution.removeCoveredIntervalsPriorityQueue(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveCoveredIntervalsSort1(int[][] intervals, int expected) {
        // given
        RemoveCoveredIntervals solution = new RemoveCoveredIntervals();

        // when
        int result = solution.removeCoveredIntervalsSort1(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveCoveredIntervalsSort2(int[][] intervals, int expected) {
        // given
        RemoveCoveredIntervals solution = new RemoveCoveredIntervals();

        // when
        int result = solution.removeCoveredIntervalsSort2(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}