package us.slemjet.leetcode.hard.tasks_1201_1250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumProfitInJobSchedulingTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}, 120),
                Arguments.of(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}, 150),
                Arguments.of(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testJobSchedulingTree(int[] startTime, int[] endTime, int[] profit, int expected) {
        // given
        MaximumProfitInJobScheduling solution = new MaximumProfitInJobScheduling();

        // when
        int result = solution.jobSchedulingTree(startTime, endTime, profit);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testJobScheduling(int[] startTime, int[] endTime, int[] profit, int expected) {
        // given
        MaximumProfitInJobScheduling solution = new MaximumProfitInJobScheduling();

        // when
        int result = solution.jobScheduling(startTime, endTime, profit);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}