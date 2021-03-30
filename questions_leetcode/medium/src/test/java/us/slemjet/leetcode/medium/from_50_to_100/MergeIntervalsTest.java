package us.slemjet.leetcode.medium.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MergeIntervalsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}},
                        new int[][]{new int[]{1, 6}, new int[]{8, 10}, new int[]{15, 18}}),
                Arguments.of(new int[][]{new int[]{1, 4}, new int[]{4, 5}},
                        new int[][]{new int[]{1, 5}}),
                Arguments.of(new int[][]{new int[]{1, 4}, new int[]{0, 4}},
                        new int[][]{new int[]{0, 4}}),
                Arguments.of(new int[][]{},
                        new int[][]{})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void merge(int[][] intervals, int[][] expected) {
        // given
        MergeIntervals solution = new MergeIntervals();

        // when
        int[][] result = solution.merge(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void merge2(int[][] intervals, int[][] expected) {
        // given
        MergeIntervals solution = new MergeIntervals();

        // when
        int[][] result = solution.merge2(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
