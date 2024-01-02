package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FlipGameIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("++++", true),
                Arguments.of("+", false),
                Arguments.of("+++++++++", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUpDP(String currentState, boolean expected) {
        // given
        FlipGameII solution = new FlipGameII();

        // when
        boolean result = solution.canWin(currentState);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}