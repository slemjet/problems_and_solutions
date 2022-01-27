package us.slemjet.leetcode.easy.from_351_to_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IsSubsequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of(null, "ahbgdc", false),
                Arguments.of("axc", null, false),
                Arguments.of("axc", "", false),
                Arguments.of("", "ahbgdc", true),
                Arguments.of("", "", true),
                Arguments.of("aaaaaa", "bbaaaa", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsSubsequence(String s, String t, boolean expected) {
        // given
        IsSubsequence solution = new IsSubsequence();

        // when
        boolean result = solution.isSubsequence(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsSubsequence2(String s, String t, boolean expected) {
        // given
        IsSubsequence solution = new IsSubsequence();

        // when
        boolean result = solution.isSubsequence2(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}