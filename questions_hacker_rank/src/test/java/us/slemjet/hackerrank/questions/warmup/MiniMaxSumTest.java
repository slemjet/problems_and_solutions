package us.slemjet.hackerrank.questions.warmup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MiniMaxSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(1, 3, 5, 7, 9)),
                Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(List<Integer> arr) {

        // given
        MiniMaxSum solution = new MiniMaxSum();

        // when
        solution.miniMaxSum(arr);

        // then
        // Prints to console
    }
}