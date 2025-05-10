package us.slemjet.hackerrank.questions.warmup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StaircaseTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4),
                Arguments.of(6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int n) {

        // given
        Staircase solution = new Staircase();

        // when
        solution.staircase(n);

        // then
        // Prints to console
    }
}