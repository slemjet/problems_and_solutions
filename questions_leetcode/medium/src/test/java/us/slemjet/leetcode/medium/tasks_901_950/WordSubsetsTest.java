package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class WordSubsetsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                        new String[]{"e", "o"},
                        List.of("facebook", "google", "leetcode")),
                Arguments.of(
                        new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                        new String[]{"l", "e"},
                        List.of("apple", "google", "leetcode")),
                Arguments.of(
                        new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                        new String[]{"lo", "eo"},
                        List.of("google", "leetcode"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordSubsets(String[] words1, String[] words2, List<String> expected) {
        // given
        WordSubsets solution = new WordSubsets();

        // when
        List<String> result = solution.wordSubsets(words1, words2);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}