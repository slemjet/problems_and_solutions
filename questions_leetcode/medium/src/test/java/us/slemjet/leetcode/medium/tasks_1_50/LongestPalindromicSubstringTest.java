package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestPalindromicSubstringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("ccc", "ccc"),
                Arguments.of("aaaa", "aaaa"),
                Arguments.of("tattarrattat", "tattarrattat"),
                Arguments.of("babaddtattarrattatddetartrateedredividerb", "ddtattarrattatdd")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestPalindrome(String input, String expected) {
        // given
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        // when
        String longestPalindrome = solution.longestPalindrome(input);

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestPalindrome2(String input, String expected) {
        // given
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        // when
        String longestPalindrome = solution.longestPalindrome2(input);

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo(expected);
    }
}
