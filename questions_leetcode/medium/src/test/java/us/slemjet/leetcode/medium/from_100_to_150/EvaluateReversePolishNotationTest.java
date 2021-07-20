package us.slemjet.leetcode.medium.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EvaluateReversePolishNotationTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"18"}, 18),
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testEvalRPN(String[] tokens, int expected) {
        // given
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        // when
        int result = solution.evalRPN(tokens);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}