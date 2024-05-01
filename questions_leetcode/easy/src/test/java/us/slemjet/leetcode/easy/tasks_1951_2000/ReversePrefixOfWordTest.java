package us.slemjet.leetcode.easy.tasks_1951_2000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReversePrefixOfWordTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abcdefd", "d", "dcbaefd"),
                Arguments.of("xyxzxe", "z", "zxyxxe"),
                Arguments.of("abcd", "z", "abcd")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String word, char ch, String expected) {
        // given
        ReversePrefixOfWord solution = new ReversePrefixOfWord();

        // when
        String result = solution.reversePrefix(word, ch);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}