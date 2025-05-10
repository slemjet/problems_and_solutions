package us.slemjet.hackerrank.questions.warmup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class PlusMinusTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 0, -1, -1)),
                Arguments.of(List.of(-4, 3, -9, 0, 4, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(List<Integer> arr) {

        // given
        PlusMinus solution = new PlusMinus();

        // when
        solution.plusMinus(arr);

        // then
        // Prints to console
    }

}