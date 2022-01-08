package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestSubstringWithAtLeastKRepeatingCharactersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aaabb", 3, 3),
                Arguments.of("ababbc", 2, 5),
                Arguments.of("aaabbb", 3, 6),
                Arguments.of("weitong", 2, 0),
                Arguments.of("ababacb", 3, 0),
                Arguments.of("bbaaacbd", 3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestSubstring(String s, int k, int expected) {
        // given
        LongestSubstringWithAtLeastKRepeatingCharacters solution = new LongestSubstringWithAtLeastKRepeatingCharacters();

        // when
        int result = solution.longestSubstring(s, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLongestSubstring2(String s, int k, int expected) {
        // given
        LongestSubstringWithAtLeastKRepeatingCharacters solution = new LongestSubstringWithAtLeastKRepeatingCharacters();

        // when
        int result = solution.longestSubstring2(s, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}