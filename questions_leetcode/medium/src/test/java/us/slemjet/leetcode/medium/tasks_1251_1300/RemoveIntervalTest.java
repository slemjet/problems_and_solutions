package us.slemjet.leetcode.medium.tasks_1251_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class RemoveIntervalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                                new int[]{0, 2},
                                new int[]{3, 4},
                                new int[]{5, 7}}, new int[]{1, 6},
                        List.of(
                                List.of(0, 1),
                                List.of(6, 7))),
                Arguments.of(new int[][]{
                                new int[]{0, 5}}, new int[]{2, 3},
                        List.of(
                                List.of(0, 2),
                                List.of(3, 5))),
                Arguments.of(new int[][]{
                                new int[]{-5, -4},
                                new int[]{-3, -2},
                                new int[]{1, 2},
                                new int[]{3, 5},
                                new int[]{8, 9}}, new int[]{-1, 4},
                        List.of(
                                List.of(-5, -4),
                                List.of(-3, -2),
                                List.of(4, 5),
                                List.of(8, 9)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] intervals, int[] toBeRemoved, List<List<Integer>> expected) {
        // given
        RemoveInterval solution = new RemoveInterval();

        // when
        List<List<Integer>> result = solution.removeInterval(intervals, toBeRemoved);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}