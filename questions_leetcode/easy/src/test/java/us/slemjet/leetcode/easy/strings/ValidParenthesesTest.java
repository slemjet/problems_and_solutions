package us.slemjet.leetcode.easy.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidParenthesesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([)]", false),
                Arguments.of("{[]}", true),
                Arguments.of("[([]])", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isValidTest(String s, boolean expected) {
        // given
        ValidParentheses solution = new ValidParentheses();

        // when
        boolean isValid = solution.isValid(s);

        // then
        Assertions.assertThat(isValid).isEqualTo(expected);
    }
}