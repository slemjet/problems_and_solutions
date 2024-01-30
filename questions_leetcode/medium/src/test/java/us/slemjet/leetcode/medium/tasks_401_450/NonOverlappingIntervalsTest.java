package us.slemjet.leetcode.medium.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NonOverlappingIntervalsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{3, 4},
                        new int[]{1, 3}}, 1),
                Arguments.of(new int[][]{
                        new int[]{1, 2},
                        new int[]{1, 2},
                        new int[]{1, 2}}, 2),
                Arguments.of(new int[][]{
                        new int[]{1, 2},
                        new int[]{2, 3}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionGreedy(int[][] intervals, int expected) {
        // given
        NonOverlappingIntervals solution = new NonOverlappingIntervals();

        // when
        int result = solution.eraseOverlapIntervalsGreedy(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionMemo(int[][] intervals, int expected) {
        // given
        NonOverlappingIntervals solution = new NonOverlappingIntervals();

        // when
        int result = solution.eraseOverlapIntervalsMemo(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTabulation(int[][] intervals, int expected) {
        // given
        NonOverlappingIntervals solution = new NonOverlappingIntervals();

        // when
        int result = solution.eraseOverlapIntervalsTabulation(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}