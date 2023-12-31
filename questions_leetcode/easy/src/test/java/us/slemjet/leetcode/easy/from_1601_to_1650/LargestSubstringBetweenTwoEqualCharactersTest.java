package us.slemjet.leetcode.easy.from_1601_to_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LargestSubstringBetweenTwoEqualCharactersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aa", 0),
                Arguments.of("abca", 2),
                Arguments.of("cbzxy", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(String s, int expected) {
        // given
        LargestSubstringBetweenTwoEqualCharacters solution = new LargestSubstringBetweenTwoEqualCharacters();

        // when
        int result = solution.maxLengthBetweenEqualCharacters(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}