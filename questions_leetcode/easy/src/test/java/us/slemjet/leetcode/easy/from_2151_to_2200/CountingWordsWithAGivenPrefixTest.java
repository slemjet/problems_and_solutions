package us.slemjet.leetcode.easy.from_2151_to_2200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountingWordsWithAGivenPrefixTest {


    public static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"pay", "attention", "practice", "attend"}, "at", 2),
                Arguments.of(new String[]{"leetcode", "win", "loops", "success"}, "code", 0)
        );
    }

    @MethodSource("parameters")
    @ParameterizedTest
    public void testPrefixCount(String[] words, String pref, int expected) {
        // Given
        CountingWordsWithAGivenPrefix solution = new CountingWordsWithAGivenPrefix();

        // When
        int result = solution.prefixCount(words, pref);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @MethodSource("parameters")
    @ParameterizedTest
    public void testPrefixCountShort(String[] words, String pref, int expected) {
        // Given
        CountingWordsWithAGivenPrefix solution = new CountingWordsWithAGivenPrefix();

        // When
        int result = solution.prefixCountShort(words, pref);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}