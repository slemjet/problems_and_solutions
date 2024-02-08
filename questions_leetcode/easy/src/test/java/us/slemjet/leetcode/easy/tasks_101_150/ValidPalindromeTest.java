package us.slemjet.leetcode.easy.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidPalindromeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(".,", true),
                Arguments.of("0P", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isPalindromeTest(String s, boolean expected) {
        // given
        ValidPalindrome solution = new ValidPalindrome();

        // when
        boolean result = solution.isPalindrome(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
