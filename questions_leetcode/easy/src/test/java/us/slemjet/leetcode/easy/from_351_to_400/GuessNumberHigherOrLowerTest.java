package us.slemjet.leetcode.easy.from_351_to_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GuessNumberHigherOrLowerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(10, 6, 6),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGuessNumber(int n, int number, int expected) {
        // given
        GuessNumberHigherOrLower solution = new GuessNumberHigherOrLower(number);

        // when
        int result = solution.guessNumber(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}