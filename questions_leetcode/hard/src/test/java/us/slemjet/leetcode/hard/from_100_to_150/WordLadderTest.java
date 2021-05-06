package us.slemjet.leetcode.hard.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class WordLadderTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
                Arguments.of("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"), 5),
                // The endWord "cog" is not in wordList
                Arguments.of("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void ladderLengthTest(String beginWord, String endWord, List<String> wordList, int expected) {
        // given
        WordLadder solution = new WordLadder();

        // when
        int result = solution.ladderLength(beginWord, endWord, wordList);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
