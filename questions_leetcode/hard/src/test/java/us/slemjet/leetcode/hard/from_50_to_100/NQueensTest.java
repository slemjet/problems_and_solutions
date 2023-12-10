package us.slemjet.leetcode.hard.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class NQueensTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, List.of(
                        List.of("Q"))),
                Arguments.of(2, List.of()),
                Arguments.of(4, List.of(
                        List.of(".Q..",
                                "...Q",
                                "Q...",
                                "..Q."),
                        List.of("..Q.",
                                "Q...",
                                "...Q",
                                ".Q..")))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, List<List<String>> expected) {
        // given
        NQueens solution = new NQueens();

        // when
        List<List<String>> result = solution.solveNQueens(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2(int n, List<List<String>> expected) {
        // given
        NQueens solution = new NQueens();

        // when
        List<List<String>> result = solution.solveNQueens2(n);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}