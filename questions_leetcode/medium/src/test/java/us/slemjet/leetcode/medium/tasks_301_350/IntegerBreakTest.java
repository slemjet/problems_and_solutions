package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class IntegerBreakTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(2, 1),
                of(10, 36)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIntegerBreakTopToBottom(int n, int expected) {
        // given
        IntegerBreak solution = new IntegerBreak();

        // when
        int result = solution.integerBreakTopToBottom(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIntegerBreakBottomUp(int n, int expected) {
        // given
        IntegerBreak solution = new IntegerBreak();

        // when
        int result = solution.integerBreakBottomUp(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}