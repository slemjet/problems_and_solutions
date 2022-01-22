package us.slemjet.leetcode.hard.from_1501_to_1550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StoneGameIVTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, false),
                Arguments.of(4, true),
                Arguments.of(7, false),
                Arguments.of(8, true),
                Arguments.of(17, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWinnerSquareGameTopToBottom(int n, boolean expected) {
        // given
        StoneGameIV solution = new StoneGameIV();

        // when
        boolean result = solution.winnerSquareGameTopToBottom(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWinnerSquareGameBottomUp(int n, boolean expected) {
        // given
        StoneGameIV solution = new StoneGameIV();

        // when
        boolean result = solution.winnerSquareGameBottomUp(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}