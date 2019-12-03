package com.slemjet.questions.other;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestPalindromeTest {

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
    void solutionTest(String input, String expected) {
        // when
        String result = LongestPalindrome.solution(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
