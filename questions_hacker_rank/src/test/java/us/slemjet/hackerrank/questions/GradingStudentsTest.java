package us.slemjet.hackerrank.questions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class GradingStudentsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new ArrayList<>(List.of(73, 67, 38, 33)), List.of(75, 67, 40, 33)),
                Arguments.of(new ArrayList<>(List.of(84, 29, 57)), List.of(85, 29, 57))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(List<Integer> grades, List<Integer> expected) {

        // given
        GradingStudents solution = new GradingStudents();

        // when
        List<Integer> result = solution.gradingStudents(grades);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}