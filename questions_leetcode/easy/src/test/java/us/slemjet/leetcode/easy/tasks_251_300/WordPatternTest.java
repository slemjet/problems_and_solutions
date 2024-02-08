package us.slemjet.leetcode.easy.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordPatternTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abba", "dog cat cat dog", true),
                Arguments.of("abba", "dog cat cat fish", false),
                Arguments.of("aaaa", "dog cat cat dog", false),
                Arguments.of("abba", "dog dog dog dog", false),
                Arguments.of("aaa", "aa aa aa aa", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordPattern(String pattern, String s, boolean expected) {
        // given
        WordPattern solution = new WordPattern();

        // when
        boolean result = solution.wordPattern(pattern, s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}