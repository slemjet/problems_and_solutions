package us.slemjet.leetcode.hard.tasks_50_100.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class InsertIntervalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                                new int[]{1, 3},
                                new int[]{6, 9}}, new int[]{2, 5},
                        new int[][]{
                                new int[]{1, 5},
                                new int[]{6, 9}}),
                Arguments.of(new int[][]{
                                new int[]{1, 2},
                                new int[]{3, 5},
                                new int[]{6, 7},
                                new int[]{8, 10},
                                new int[]{12, 16}}, new int[]{4, 8},
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{3, 10},
                                new int[]{12, 16}}),
                Arguments.of(new int[][]{}, new int[]{5, 7},
                        new int[][]{new int[]{5, 7}}),
                Arguments.of(new int[][]{
                                new int[]{1, 5}}, new int[]{6, 8},
                        new int[][]{
                                new int[]{1, 5},
                                new int[]{6, 8}}),
                Arguments.of(new int[][]{
                                new int[]{1, 5}}, new int[]{0, 0},
                        new int[][]{
                                new int[]{0, 0},
                                new int[]{1, 5}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] intervals, int[] newInterval, int[][] expected) {
        // given
        InsertInterval solution = new InsertInterval();

        // when
        int[][] result = solution.insert(intervals, newInterval);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int[][] intervals, int[] newInterval, int[][] expected) {
        // given
        InsertInterval solution = new InsertInterval();

        // when
        int[][] result = solution.insert(intervals, newInterval);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}