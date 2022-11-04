package us.slemjet.leetcode.easy.from_301_to_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReverseVowelsOfAStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("hello", "holle"),
                Arguments.of("leetcode", "leotcede"),
                Arguments.of(" ", " ")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testReverseVowels(String s, String expected) {
        // given
        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();

        // when
        String result = solution.reverseVowels(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}