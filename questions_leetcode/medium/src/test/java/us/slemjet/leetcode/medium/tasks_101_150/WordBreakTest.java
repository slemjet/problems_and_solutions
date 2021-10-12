package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class WordBreakTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("leetcode", Arrays.asList("leet", "code"), true),
                Arguments.of("applepenapple", Arrays.asList("apple", "pen"), true),
                Arguments.of("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"), false),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"), false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordBreak(String s, List<String> wordDict, boolean expected) {
        // given
        WordBreak solution = new WordBreak();

        // when
        boolean result = solution.wordBreak(s, wordDict);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordBreakDp2(String s, List<String> wordDict, boolean expected) {
        // given
        WordBreak solution = new WordBreak();

        // when
        boolean result = solution.wordBreakDp2(s, wordDict);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordBreakDfs(String s, List<String> wordDict, boolean expected) {
        // given
        WordBreak solution = new WordBreak();

        // when
        boolean result = solution.wordBreakDFS(s, wordDict);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("parameters")
    void testWordBreak2(String s, List<String> wordDict, boolean expected) {
        // given
        WordBreak solution = new WordBreak();

        // when
        boolean result = solution.wordBreak2(s, wordDict);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
