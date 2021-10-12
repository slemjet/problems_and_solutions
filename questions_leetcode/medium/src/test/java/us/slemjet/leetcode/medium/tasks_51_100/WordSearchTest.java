package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordSearchTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'},
                }, "ABCCED", true),
                Arguments.of(new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'},
                }, "SEE", true),
                Arguments.of(new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'},
                }, "ABCB", false),
                Arguments.of(new char[][]{
                        new char[]{'a'}
                }, "a", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void exist(char[][] board, String word, boolean expected) {
        // given
        WordSearch solution = new WordSearch();

        // when
        boolean result = solution.exist(board, word);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
