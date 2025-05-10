package us.slemjet.hackerrank.questions.warmup;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DiagonalDifferenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of(1, 2, 3),
                        List.of(4, 5, 6),
                        List.of(9, 8, 9)), 2),
                Arguments.of(List.of(
                        List.of(11, 2, 4),
                        List.of(4, 5, 6),
                        List.of(10, 8, -12)), 15)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(List<List<Integer>> arr, int expected) {

        // given
        DiagonalDifference solution = new DiagonalDifference();

        // when
        int result = solution.diagonalDifference(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}