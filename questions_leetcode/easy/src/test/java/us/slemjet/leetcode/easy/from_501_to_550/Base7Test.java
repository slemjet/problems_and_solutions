package us.slemjet.leetcode.easy.from_501_to_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Base7Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(100, "202"),
                Arguments.of(-7, "-10"),
                Arguments.of(-8, "-11"),
                Arguments.of(3, "3"),
                Arguments.of(0, "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testConvertToBase7(int num, String expected) {
        // given
        Base7 solution = new Base7();

        // when
        String result = solution.convertToBase7(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testConvertToBase7Short(int num, String expected) {
        // given
        Base7 solution = new Base7();

        // when
        String result = solution.convertToBase7Short(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testConvertToBase7VeryShort(int num, String expected) {
        // given
        Base7 solution = new Base7();

        // when
        String result = solution.convertToBase7VeryShort(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}