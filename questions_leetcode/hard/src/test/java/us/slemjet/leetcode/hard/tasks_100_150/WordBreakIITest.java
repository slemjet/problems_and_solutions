package us.slemjet.leetcode.hard.tasks_100_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class WordBreakIITest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"), Arrays.asList("cats and dog", "cat sand dog")),
                Arguments.of("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"), Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple")),
                Arguments.of("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"), new ArrayList<>()),
                Arguments.of("aaaaaaa", Arrays.asList("aaaa", "aa", "a"), Arrays.asList("a a a a a a a", "aa a a a a a", "a aa a a a a", "a a aa a a a", "aa aa a a a", "aaaa a a a", "a a a aa a a", "aa a aa a a", "a aa aa a a", "a aaaa a a", "a a a a aa a", "aa a a aa a", "a aa a aa a", "a a aa aa a", "aa aa aa a", "aaaa aa a", "a a aaaa a", "aa aaaa a", "a a a a a aa", "aa a a a aa", "a aa a a aa", "a a aa a aa", "aa aa a aa", "aaaa a aa", "a a a aa aa", "aa a aa aa", "a aa aa aa", "a aaaa aa", "a a a aaaa", "aa a aaaa", "a aa aaaa"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordBreak(String s, List<String> wordDict, List<String> expected) {
        // given
        WordBreakII solution = new WordBreakII();

        // when
        List<String> result = solution.wordBreak(s, wordDict);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordBreak2(String s, List<String> wordDict, List<String> expected) {
        // given
        WordBreakII solution = new WordBreakII();

        // when
        List<String> result = solution.wordBreak2(s, wordDict);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

}
