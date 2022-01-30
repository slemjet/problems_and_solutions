package us.slemjet.leetcode.hard.from_1301_to_1350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumStudentsTakingExamTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[][]{
                        new char[]{'#', '.', '#', '#', '.', '#'},
                        new char[]{'.', '#', '#', '#', '#', '.'},
                        new char[]{'#', '.', '#', '#', '.', '#'}}, 4),
                Arguments.of(new char[][]{
                        new char[]{'.', '#'},
                        new char[]{'#', '#'},
                        new char[]{'#', '.'},
                        new char[]{'#', '#'},
                        new char[]{'.', '#'}}, 3),
                Arguments.of(new char[][]{
                        new char[]{'#', '.', '.', '.', '#'},
                        new char[]{'.', '#', '.', '#', '.'},
                        new char[]{'.', '.', '#', '.', '.'},
                        new char[]{'.', '#', '.', '#', '.'},
                        new char[]{'#', '.', '.', '.', '#'}}, 10),
                Arguments.of(new char[][]{
                        new char[]{'#', '.', '.'},
                        new char[]{'.', '#', '.'}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxStudents(char[][] seats, int expected) {
        // given
        MaximumStudentsTakingExam solution = new MaximumStudentsTakingExam();

        // when
        int result = solution.maxStudents(seats);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxStudents2(char[][] seats, int expected) {
        // given
        MaximumStudentsTakingExam solution = new MaximumStudentsTakingExam();

        // when
        int result = solution.maxStudents2(seats);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}