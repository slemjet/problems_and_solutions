package us.slemjet.leetcode.medium.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DailyTemperaturesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                Arguments.of(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
                Arguments.of(new int[]{30, 60, 90}, new int[]{1, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] temperatures, int[] expected) {
        // given
        DailyTemperatures solution = new DailyTemperatures();

        // when
        int[] result = solution.dailyTemperatures(temperatures);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}