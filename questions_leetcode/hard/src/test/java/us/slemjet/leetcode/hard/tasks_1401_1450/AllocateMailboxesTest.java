package us.slemjet.leetcode.hard.tasks_1401_1450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AllocateMailboxesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 8, 10, 20}, 3, 5),
                Arguments.of(new int[]{2, 3, 5, 12, 18}, 2, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinDistanceBottomUp(int[] houses, int k, int expected) {
        // given
        AllocateMailboxes solution = new AllocateMailboxes();

        // when
        int value = solution.minDistanceBottomUp(houses, k);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinDistanceTopToBottom(int[] houses, int k, int expected) {
        // given
        AllocateMailboxes solution = new AllocateMailboxes();

        // when
        int value = solution.minDistanceTopToBottom(houses, k);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}