package us.slemjet.leetcode.hard.tasks_2101_2150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EarliestPossibleDayOfFullBloomTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 3}, new int[]{2, 3, 1}, 9),
                Arguments.of(new int[]{1, 2, 3, 2}, new int[]{2, 1, 2, 1}, 9),
                Arguments.of(new int[]{1}, new int[]{1}, 2),
                Arguments.of(new int[]{27, 5, 24, 17, 27, 4, 23, 16, 6, 26, 13, 17, 21, 3, 9, 10, 28, 26, 4, 10, 28, 2},
                        new int[]{26, 9, 14, 17, 6, 14, 23, 24, 11, 6, 27, 14, 13, 1, 15, 5, 12, 15, 23, 27, 28, 12}, 348)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testEarliestFullBloom(int[] plantTime, int[] growTime, int expected) {
        // given
        EarliestPossibleDayOfFullBloom solution = new EarliestPossibleDayOfFullBloom();

        // when
        int result = solution.earliestFullBloom(plantTime, growTime);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}