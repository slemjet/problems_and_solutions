package us.slemjet.leetcode.medium.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestPalindromicSubsequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("bbbab", 4),
                Arguments.of("cbbd", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestPalindromeTopToBottom(String s, int expected) {
        // given
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();

        // when
        int longestPalindrome = solution.longestPalindromeSubseqTopToBottom(s);

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestPalindromeSubseqBottomUp(String s, int expected) {
        // given
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();

        // when
        int longestPalindrome = solution.longestPalindromeSubseqBottomUp(s);

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo(expected);
    }
}