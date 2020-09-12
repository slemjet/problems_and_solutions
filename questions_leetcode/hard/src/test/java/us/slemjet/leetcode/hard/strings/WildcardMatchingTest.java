package us.slemjet.leetcode.hard.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WildcardMatchingTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aa", "a", false),
                Arguments.of("aa", "*", true),
                Arguments.of("cb", "?a", false),
                Arguments.of("abced", "*a*b", false),
                Arguments.of("acdcb", "a*c?b", false),
                Arguments.of("acdcb", "a*cd?b", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isMatch(String s, String p, boolean expected) {
        // given
        WildcardMatching solution = new WildcardMatching();

        // when
        boolean result = solution.isMatch(s, p);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isMatchDp(String s, String p, boolean expected) {
        // given
        WildcardMatching solution = new WildcardMatching();

        // when
        boolean result = solution.isMatchDp(s, p);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
