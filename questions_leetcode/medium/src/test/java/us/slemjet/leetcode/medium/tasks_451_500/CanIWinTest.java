package us.slemjet.leetcode.medium.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CanIWinTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(10, 11, false),
                Arguments.of(10, 0, true),
                Arguments.of(10, 1, true),
                Arguments.of(4, 6, true),
                Arguments.of(10, 40, false),
                Arguments.of(5, 50, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int maxChoosableInteger, int desiredTotal, boolean expected) {
        // given
        CanIWin solution = new CanIWin();

        // when
        boolean result = solution.canIWin(maxChoosableInteger, desiredTotal);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}