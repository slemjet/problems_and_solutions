package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveDuplicateLettersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("bcabc", "abc"),
                Arguments.of("cbacdcbc", "acdb"),
                Arguments.of("cdadabcc", "adbc"),
                Arguments.of("abacb", "abc")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveDuplicateLetters(String s, String expected) {
        // given
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();

        // when
        String result = solution.removeDuplicateLetters(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveDuplicateLetters2(String s, String expected) {
        // given
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();

        // when
        String result = solution.removeDuplicateLetters2(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}