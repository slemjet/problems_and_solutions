package us.slemjet.leetcode.easy.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RepeatedSubstringPatternTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abab", true),
                Arguments.of("aba", false),
                Arguments.of("abcabcabcabc", true),
                Arguments.of("bb", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void repeatedSubstringPattern(String s, boolean expected) {
        // when
        boolean isValid = RepeatedSubstringPattern.repeatedSubstringPattern(s);

        // then
        Assertions.assertThat(isValid).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void repeatedSubstringPatternConcatSubstr(String s, boolean expected) {
        // when
        boolean isValid = RepeatedSubstringPattern.repeatedSubstringPatternConcatSubstr(s);

        // then
        Assertions.assertThat(isValid).isEqualTo(expected);
    }
}
