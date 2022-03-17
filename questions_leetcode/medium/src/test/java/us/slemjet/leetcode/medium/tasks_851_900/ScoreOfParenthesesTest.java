package us.slemjet.leetcode.medium.tasks_851_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ScoreOfParenthesesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("()", 1),
                Arguments.of("(())", 2),
                Arguments.of("()()", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testValidateStackSequences(String s, int expected) {
        // given
        ScoreOfParentheses solution = new ScoreOfParentheses();

        // when
        int result = solution.scoreOfParentheses(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testValidateStackSequencesStack(String s, int expected) {
        // given
        ScoreOfParentheses solution = new ScoreOfParentheses();

        // when
        int result = solution.scoreOfParenthesesStack(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}