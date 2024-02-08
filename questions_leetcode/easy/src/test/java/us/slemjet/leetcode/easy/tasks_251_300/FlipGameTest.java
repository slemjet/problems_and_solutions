package us.slemjet.leetcode.easy.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FlipGameTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("++++", List.of("--++", "+--+", "++--")),
                Arguments.of("+", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String currentState, List<String> expected) {
        // given
        FlipGame solution = new FlipGame();

        // when
        List<String> result = solution.generatePossibleNextMoves(currentState);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}