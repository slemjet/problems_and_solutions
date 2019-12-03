package us.slemjet.leetcode.hard.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("(()", 2),
                Arguments.of(")()())", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void longestValidParentheses(String s, int expected) {
        // given
        LongestValidParentheses solution = new LongestValidParentheses();

        // when
        int result = solution.longestValidParentheses(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void longestValidParenthesesDynamic(String s, int expected) {
        // given
        LongestValidParentheses solution = new LongestValidParentheses();

        // when
        int result = solution.longestValidParenthesesDynamic(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
