package us.slemjet.leetcode.medium.tasks_1351_1400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumNumberOfEventsThatCanBeAttendedTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}}, 3),
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 2}}, 4),
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{3, 3}, new int[]{1, 5}, new int[]{1, 5}}, 5),
                Arguments.of(new int[][]{new int[]{1, 5}, new int[]{1, 5}, new int[]{1, 5}, new int[]{2, 3}, new int[]{2, 3}}, 5),
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 6}, new int[]{1, 2}, new int[]{1, 2}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] events, int expected) {
        // given
        MaximumNumberOfEventsThatCanBeAttended solution = new MaximumNumberOfEventsThatCanBeAttended();

        // when
        int result = solution.maxEvents(events);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}