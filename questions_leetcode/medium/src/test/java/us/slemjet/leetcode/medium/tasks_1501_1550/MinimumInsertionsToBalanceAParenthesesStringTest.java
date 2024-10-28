package us.slemjet.leetcode.medium.tasks_1501_1550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumInsertionsToBalanceAParenthesesStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("(()))", 1),
                Arguments.of("())", 0),
                Arguments.of("))())(", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetWinner(String s, int expected) {
        // given
        MinimumInsertionsToBalanceAParenthesesString solution = new MinimumInsertionsToBalanceAParenthesesString();

        // when
        int result = solution.minInsertions(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}