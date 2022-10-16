package us.slemjet.leetcode.medium.tasks_1551_1600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfDiceRollsWithTargetSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 6, 3, 1),
                Arguments.of(2, 6, 7, 6),
                Arguments.of(30, 30, 500, 222616187)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumRollsToTargetTopToBottom(int n, int k, int target, int expected) {
        // given
        NumberOfDiceRollsWithTargetSum solution = new NumberOfDiceRollsWithTargetSum();

        // when
        int result = solution.numRollsToTargetTopToBottom(n, k, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumRollsToTargetBottomUp(int n, int k, int target, int expected) {
        // given
        NumberOfDiceRollsWithTargetSum solution = new NumberOfDiceRollsWithTargetSum();

        // when
        int result = solution.numRollsToTargetBottomUp(n, k, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}