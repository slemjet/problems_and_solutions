package us.slemjet.leetcode.hard.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ScrambleStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("great", "rgeat", true),
                Arguments.of("abc", "bca", true),
                Arguments.of("abc", "cba", true),
                Arguments.of("ac", "ca", true),
                Arguments.of("abcde", "caebd", false),
                Arguments.of("abcde", "abcde", true),
                Arguments.of("a", "a", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsScrambleDp(String s1, String s2, boolean expected) {
        // given
        ScrambleString solution = new ScrambleString();

        // when
        boolean result = solution.isScrambleDp(s1, s2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsScramble(String s1, String s2, boolean expected) {
        // given
        ScrambleString solution = new ScrambleString();

        // when
        boolean result = solution.isScramble(s1, s2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}