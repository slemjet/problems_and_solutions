package us.slemjet.leetcode.easy.tasks_2051_2100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class TimeNeededToBuyTicketsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{2, 3, 2}, 2, 6),
                of(new int[]{5, 1, 1, 1}, 0, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] tickets, int k, int expected) {
        // given
        TimeNeededToBuyTickets solution = new TimeNeededToBuyTickets();

        // when
        int result = solution.timeRequiredToBuy(tickets, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int[] tickets, int k, int expected) {
        // given
        TimeNeededToBuyTickets solution = new TimeNeededToBuyTickets();

        // when
        int result = solution.timeRequiredToBuy2(tickets, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}