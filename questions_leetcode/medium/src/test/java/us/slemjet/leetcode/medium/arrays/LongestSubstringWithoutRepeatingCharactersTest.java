package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.arrays.LongestSubstringWithoutRepeatingCharacters;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

class LongestSubstringWithoutRepeatingCharactersTest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("abcabcbb", 3),
                of("bbbbb", 1),
                of("pwwkew", 3),
                of(" ", 1),
                of("", 0),
                of("dvdf", 3),
                of("au", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String input, int expected) {
        // given
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        // when
        int length1 = solution.lengthOfLongestSubstring(input);

        // then
        Assertions.assertThat(length1).isEqualTo(expected);
    }
}
