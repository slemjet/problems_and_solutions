package us.slemjet.leetcode.medium.tasks_601_650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TaskSchedulerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2, 8),
                Arguments.of(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1, 6),
                Arguments.of(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3, 10),
                Arguments.of(new char[]{'A', 'B', 'A'}, 2, 4),
                Arguments.of(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 1, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(char[] tasks, int n, int expected) {
        // given
        TaskScheduler solution = new TaskScheduler();

        // when
        int result = solution.leastInterval(tasks, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(char[] tasks, int n, int expected) {
        // given
        TaskScheduler solution = new TaskScheduler();

        // when
        int result = solution.leastInterval2(tasks, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}