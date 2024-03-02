package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestStringChainTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}, 4),
                Arguments.of(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5),
                Arguments.of(new String[]{"abcd", "dbqca"}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopToBottom(String[] words, int expected) {
        // given
        LongestStringChain solution = new LongestStringChain();

        // when
        int result = solution.longestStrChainTopToBottom(words);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(String[] words, int expected) {
        // given
        LongestStringChain solution = new LongestStringChain();

        // when
        int result = solution.longestStrChainBottomUp(words);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}