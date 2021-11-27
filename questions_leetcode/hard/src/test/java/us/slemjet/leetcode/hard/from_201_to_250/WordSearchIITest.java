package us.slemjet.leetcode.hard.from_201_to_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class WordSearchIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[][]{
                                new char[]{'o', 'a', 'a', 'n'},
                                new char[]{'e', 't', 'a', 'e'},
                                new char[]{'i', 'h', 'k', 'r'},
                                new char[]{'i', 'f', 'l', 'v'}},
                        new String[]{"oath", "pea", "eat", "rain", "on"},
                        Arrays.asList("eat", "oath")),
                Arguments.of(new char[][]{
                                new char[]{'a', 'b'},
                                new char[]{'c', 'd'}},
                        new String[]{"abcb"},
                        new ArrayList<>())

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindWords(char[][] board, String[] words, List<String> expected) {
        // given
        WordSearchII solution = new WordSearchII();

        // when
        List<String> result = solution.findWords(board, words);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindWords2(char[][] board, String[] words, List<String> expected) {
        // given
        WordSearchII solution = new WordSearchII();

        // when
        List<String> result = solution.findWords2(board, words);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}