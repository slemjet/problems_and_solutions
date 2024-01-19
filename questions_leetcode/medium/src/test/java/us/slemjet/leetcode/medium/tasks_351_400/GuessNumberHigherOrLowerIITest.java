package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GuessNumberHigherOrLowerIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(25, 64),
                Arguments.of(10, 16),
                Arguments.of(1, 0),
                Arguments.of(2, 1),
                Arguments.of(3, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(int n, int expected) {
        // given
        GuessNumberHigherOrLowerII solution = new GuessNumberHigherOrLowerII();

        // when
        int result = solution.getMoneyAmountTopDown(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(int n, int expected) {
        // given
        GuessNumberHigherOrLowerII solution = new GuessNumberHigherOrLowerII();

        // when
        int result = solution.getMoneyAmountBottomUp(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}