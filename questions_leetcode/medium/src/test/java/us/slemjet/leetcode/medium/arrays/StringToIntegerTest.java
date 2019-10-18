package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringToIntegerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("   -42", -42),
                Arguments.of("4193 with words", 4193),
                Arguments.of("words and 987", 0),
                Arguments.of("-91283472332", -2147483648),
                Arguments.of("3.14159", 3),
                Arguments.of("+-2", 0),
                Arguments.of("2147483648", 2147483647),
                Arguments.of("2147483646", 2147483646),
                Arguments.of("-2147483647", -2147483647)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String input, int expected) {
        // given
        StringToInteger solution = new StringToInteger();

        // when
        int value = solution.atoi(input);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}