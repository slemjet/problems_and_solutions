package us.slemjet.leetcode.easy.from_1401_to_1450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class NumberOfStudentsDoingHomeworkAtAGivenTimeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4, 1),
                of(new int[]{4}, new int[]{4}, 4, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBusyStudent(int[] startTime, int[] endTime, int queryTime, int expected) {
        // given
        NumberOfStudentsDoingHomeworkAtAGivenTime solution = new NumberOfStudentsDoingHomeworkAtAGivenTime();

        // when
        int result = solution.busyStudent(startTime, endTime, queryTime);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBusyStudent2(int[] startTime, int[] endTime, int queryTime, int expected) {
        // given
        NumberOfStudentsDoingHomeworkAtAGivenTime solution = new NumberOfStudentsDoingHomeworkAtAGivenTime();

        // when
        int result = solution.busyStudent2(startTime, endTime, queryTime);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}