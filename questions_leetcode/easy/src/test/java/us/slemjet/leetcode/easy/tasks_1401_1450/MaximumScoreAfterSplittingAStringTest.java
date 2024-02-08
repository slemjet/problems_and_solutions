package us.slemjet.leetcode.easy.tasks_1401_1450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumScoreAfterSplittingAStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("011101", 5),
                Arguments.of("00111", 5),
                Arguments.of("1111", 3),
                Arguments.of("00", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        MaximumScoreAfterSplittingAString solution = new MaximumScoreAfterSplittingAString();

        // when
        int result = solution.maxScore(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionOnePass(String s, int expected) {
        // given
        MaximumScoreAfterSplittingAString solution = new MaximumScoreAfterSplittingAString();

        // when
        int result = solution.maxScoreOnePass(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}