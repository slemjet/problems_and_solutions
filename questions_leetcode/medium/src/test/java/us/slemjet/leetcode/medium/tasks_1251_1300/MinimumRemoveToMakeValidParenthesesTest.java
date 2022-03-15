package us.slemjet.leetcode.medium.tasks_1251_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MinimumRemoveToMakeValidParenthesesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("lee(t(c)o)de)", List.of("lee(t(c)o)de", "lee(t(co)de)", "lee(t(c)ode)")),
                Arguments.of("a)b(c)d", List.of("ab(c)d")),
                Arguments.of("a)b(c)(d", List.of("ab(c)d")),
                Arguments.of("))((", List.of(""))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinRemoveToMakeValid(String s, List<String> expected) {
        // given
        MinimumRemoveToMakeValidParentheses solution = new MinimumRemoveToMakeValidParentheses();

        // when
        String result = solution.minRemoveToMakeValid(s);

        // then
        Assertions.assertThat(result).isIn(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinRemoveToMakeValid2(String s, List<String> expected) {
        // given
        MinimumRemoveToMakeValidParentheses solution = new MinimumRemoveToMakeValidParentheses();

        // when
        String result = solution.minRemoveToMakeValid2(s);

        // then
        Assertions.assertThat(result).isIn(expected);
    }
}