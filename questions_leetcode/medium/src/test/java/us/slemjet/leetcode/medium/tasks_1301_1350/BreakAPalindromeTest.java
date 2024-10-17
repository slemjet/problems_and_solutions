package us.slemjet.leetcode.medium.tasks_1301_1350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BreakAPalindromeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abccba", "aaccba"),
                Arguments.of("a", ""),
                Arguments.of("b", "")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String palindrome, String expected) {
        // given
        BreakAPalindrome solution = new BreakAPalindrome();

        // when
        String result = solution.breakPalindrome(palindrome);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}