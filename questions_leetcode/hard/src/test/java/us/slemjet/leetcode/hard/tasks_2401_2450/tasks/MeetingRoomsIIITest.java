package us.slemjet.leetcode.hard.tasks_2401_2450.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MeetingRoomsIIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, new int[][]{
                        new int[]{0, 10},
                        new int[]{1, 5},
                        new int[]{2, 7},
                        new int[]{3, 4}}, 0),
                Arguments.of(3, new int[][]{
                        new int[]{1, 20},
                        new int[]{2, 10},
                        new int[]{3, 5},
                        new int[]{4, 9},
                        new int[]{6, 8}}, 1),
                Arguments.of(4, new int[][]{
                        new int[]{18, 19},
                        new int[]{3, 12},
                        new int[]{17, 19},
                        new int[]{2, 13},
                        new int[]{7, 10}}, 0),
                Arguments.of(2, new int[][]{
                        new int[]{10, 11},
                        new int[]{2, 10},
                        new int[]{1, 17},
                        new int[]{9, 13},
                        new int[]{18, 20}}, 1),
                Arguments.of(4, new int[][]{
                        new int[]{48, 49},
                        new int[]{22, 30},
                        new int[]{13, 31},
                        new int[]{31, 46},
                        new int[]{37, 46},
                        new int[]{32, 36},
                        new int[]{25, 36},
                        new int[]{49, 50},
                        new int[]{24, 34},
                        new int[]{6, 41},}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int[][] meetings, int expected) {
        // given
        MeetingRoomsIII solution = new MeetingRoomsIII();

        // when
        int result = solution.mostBooked(n, meetings);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}