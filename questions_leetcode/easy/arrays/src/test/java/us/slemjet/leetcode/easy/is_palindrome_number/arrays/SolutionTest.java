package us.slemjet.leetcode.easy.is_palindrome_number.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false),
                Arguments.of(0, true),
                Arguments.of(1000021, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isPalindrome(int input, boolean expected) {
        // given
        Solution solution = new Solution();

        // when
        Boolean palindrome = solution.isPalindrome(input);

        // then
        Assertions.assertThat(palindrome).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isPalindrome2(int input, boolean expected) {
        // given
        Solution solution = new Solution();

        // when
        Boolean palindrome = solution.isPalindrome2(input);

        // then
        Assertions.assertThat(palindrome).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isPalindrome3(int input, boolean expected) {
        // given
        Solution solution = new Solution();

        // when
        Boolean palindrome = solution.isPalindrome3(input);

        // then
        Assertions.assertThat(palindrome).isEqualTo(expected);
    }
}