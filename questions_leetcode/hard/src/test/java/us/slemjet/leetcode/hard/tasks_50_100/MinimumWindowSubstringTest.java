package us.slemjet.leetcode.hard.tasks_50_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumWindowSubstringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("a", "a", "a"),
                Arguments.of("a", "aa", ""),
                Arguments.of("cabeca", "cae", "eca")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void minWindow(String s, String t, String expected) {
        // given
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        // when
        String result = solution.minWindow(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void minWindowArr(String s, String t, String expected) {
        // given
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        // when
        String result = solution.minWindow2Pointers(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
