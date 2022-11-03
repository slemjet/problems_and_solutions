package us.slemjet.leetcode.medium.tasks_2101_2050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestPalindromeByConcatenatingTwoLetterWordsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"lc", "cl", "gg"}, 6),
                Arguments.of(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}, 8),
                Arguments.of(new String[]{"cc", "ll", "xx"}, 2),
                Arguments.of(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"}, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestPalindrome(String[] words, int expected) {
        // given
        LongestPalindromeByConcatenatingTwoLetterWords solution = new LongestPalindromeByConcatenatingTwoLetterWords();

        // when
        int result = solution.longestPalindrome(words);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}