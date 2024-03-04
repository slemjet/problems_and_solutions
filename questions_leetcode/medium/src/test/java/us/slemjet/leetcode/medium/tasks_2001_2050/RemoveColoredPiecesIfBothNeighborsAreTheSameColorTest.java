package us.slemjet.leetcode.medium.tasks_2001_2050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveColoredPiecesIfBothNeighborsAreTheSameColorTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("AAABABB", true),
                Arguments.of("AA", false),
                Arguments.of("ABBBBBBBAAA", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String colors, boolean expected) {
        // given
        RemoveColoredPiecesIfBothNeighborsAreTheSameColor solution = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor();

        // when
        boolean result = solution.winnerOfGame(colors);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}