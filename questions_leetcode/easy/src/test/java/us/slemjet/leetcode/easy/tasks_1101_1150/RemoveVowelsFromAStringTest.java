package us.slemjet.leetcode.easy.tasks_1101_1150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveVowelsFromAStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("leetcodeisacommunityforcoders", "ltcdscmmntyfrcdrs"),
                Arguments.of("aeiou", "")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, String expected) {
        // given
        RemoveVowelsFromAString solution = new RemoveVowelsFromAString();

        // when
        String result = solution.removeVowels(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}