package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RomanToIntegerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("IX", 9),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("MMMDXLIX", 3549)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void romanToInt(String s, int expected) {
        // given
        RomanToInteger solution = new RomanToInteger();

        // when
        int number = solution.romanToInt(s);

        // then
        Assertions.assertThat(number).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void romanToInt2(String s, int expected) {
        // given
        RomanToInteger solution = new RomanToInteger();

        // when
        int number = solution.romanToInt(s);

        // then
        Assertions.assertThat(number).isEqualTo(expected);
    }
}