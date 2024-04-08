package us.slemjet.leetcode.easy.tasks_1651_1700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class NumberOfStudentsUnableToEatLunchTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}, 0),
                of(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] students, int[] sandwiches, int expected) {
        // given
        NumberOfStudentsUnableToEatLunch solution = new NumberOfStudentsUnableToEatLunch();

        // when
        int result = solution.countStudents(students, sandwiches);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}