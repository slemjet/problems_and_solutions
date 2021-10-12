package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class GenerateParenthesesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(
                        "((()))",
                        "(()())",
                        "(())()",
                        "()(())",
                        "()()()"))

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void generateParenthesis(int n, List<String> expected) {
        // given
        GenerateParentheses solution = new GenerateParentheses();

        // when
        List<String> parenthesis = solution.generateParenthesis(n);

        // then
        Assertions.assertThat(parenthesis).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void generateParenthesisDynamic(int n, List<String> expected) {
        // given
        GenerateParentheses solution = new GenerateParentheses();

        // when
        List<String> parenthesis = solution.generateParenthesisDynamic(n);

        // then
        Assertions.assertThat(parenthesis).containsExactlyInAnyOrderElementsOf(expected);
    }
}
