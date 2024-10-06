package us.slemjet.leetcode.easy.tasks_1801_1850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DetermineColorOfAChessboardSquareTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("a1", false),
                Arguments.of("h3", true),
                Arguments.of("c7", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String sentence, boolean expected) {
        // given
        DetermineColorOfAChessboardSquare solution = new DetermineColorOfAChessboardSquare();

        // when
        boolean result = solution.squareIsWhite(sentence);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}