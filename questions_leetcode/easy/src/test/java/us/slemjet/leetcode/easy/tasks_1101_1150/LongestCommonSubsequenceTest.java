package us.slemjet.leetcode.easy.tasks_1101_1150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestCommonSubsequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abcde", "ace", 3),
                Arguments.of("abc", "abc", 3),
                Arguments.of("abc", "def", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestCommonSubsequence(String text1, String text2, int expected) {
        // given
        LongestCommonSubsequence solution = new LongestCommonSubsequence();

        // when
        int result = solution.longestCommonSubsequence(text1, text2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}