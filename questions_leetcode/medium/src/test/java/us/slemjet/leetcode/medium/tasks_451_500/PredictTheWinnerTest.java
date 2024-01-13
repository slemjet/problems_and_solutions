package us.slemjet.leetcode.medium.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PredictTheWinnerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 2}, false),
                Arguments.of(new int[]{1, 5, 233, 7}, true),
                Arguments.of(new int[]{0}, true),
                Arguments.of(new int[]{1, 1}, true),
                Arguments.of(new int[]{1, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(int[] nums, boolean expected) {
        // given
        PredictTheWinner solution = new PredictTheWinner();

        // when
        boolean result = solution.predictTheWinnerTopDown(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(int[] nums, boolean expected) {
        // given
        PredictTheWinner solution = new PredictTheWinner();

        // when
        boolean result = solution.predictTheWinnerBottomUp(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}