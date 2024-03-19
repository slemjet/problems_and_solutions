package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MeetingRoomsIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20}}, 2),
                Arguments.of(new int[][]{new int[]{13, 15}, new int[]{2, 4}}, 1),
                Arguments.of(new int[][]{new int[]{13, 15}, new int[]{1, 13}}, 1),
                Arguments.of(new int[][]{new int[]{2, 11}, new int[]{6, 16}, new int[]{11, 16}}, 2),
                Arguments.of(new int[][]{new int[]{6, 17}, new int[]{8, 9}, new int[]{11, 12}, new int[]{6, 9}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] intervals, int expected) {
        // given
        MeetingRoomsII solution = new MeetingRoomsII();

        // when
        int result = solution.minMeetingRooms(intervals);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}