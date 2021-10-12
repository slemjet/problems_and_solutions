package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IntegerToRomanTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(9, "IX"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(3549, "MMMDXLIX")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void intToRoman(int num, String expected) {
        // given
        IntegerToRoman solution = new IntegerToRoman();

        // when
        String roman = solution.intToRoman(num);

        // then
        Assertions.assertThat(roman).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void intToRoman2(int num, String expected) {
        // given
        IntegerToRoman solution = new IntegerToRoman();

        // when
        String roman = solution.intToRoman2(num);

        // then
        Assertions.assertThat(roman).isEqualTo(expected);
    }
}
