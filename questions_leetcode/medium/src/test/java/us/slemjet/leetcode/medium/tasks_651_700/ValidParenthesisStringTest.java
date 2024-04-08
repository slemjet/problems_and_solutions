package us.slemjet.leetcode.medium.tasks_651_700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class ValidParenthesisStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("()", true),
                of("(*)", true),
                of("(*))", true),
                of("***)))", true),
                of("(((***", true),
                of("**************************************************))))))))))))))))))))))))))))))))))))))))))))))))))", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, boolean expected) {
        // given
        ValidParenthesisString solution = new ValidParenthesisString();

        // when
        boolean result = solution.checkValidString(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}