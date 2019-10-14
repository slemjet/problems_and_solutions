package us.slemjet.leetcode.longest_palindromic_substr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("ccc", "ccc"),
                Arguments.of("aaaa", "aaaa"),
                Arguments.of("tattarrattat", "tattarrattat")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String input, String expected) {
        // given
        Solution solution = new Solution();

        // when
        String longestPalindrome = solution.longestPalindrome(input);

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo(expected);
    }
}