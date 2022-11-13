package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseWordsInAStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world  ", "world hello"),
                Arguments.of("a good   example", "example good a")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testReverseWords(String s, String expected) {
        // given
        ReverseWordsInAString solution = new ReverseWordsInAString();

        // when
        String result = solution.reverseWords(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}