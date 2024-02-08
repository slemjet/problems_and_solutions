package us.slemjet.leetcode.medium.tasks_1201_1250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MaximumLengthOfAConcatenatedStringWithUniqueCharactersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of("un", "iq", "ue"), 4),
                Arguments.of(List.of("cha", "r", "act", "ers"), 6),
                Arguments.of(List.of("abcdefghijklmnopqrstuvwxyz"), 26),
                Arguments.of(List.of("aa", "bb"), 0)
//                Arguments.of(List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"), 16)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxLength(List<String> arr, int expected) {
        // given
        MaximumLengthOfAConcatenatedStringWithUniqueCharacters solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();

        // when
        int result = solution.maxLength(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxLengthDfs(List<String> arr, int expected) {
        // given
        MaximumLengthOfAConcatenatedStringWithUniqueCharacters solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();

        // when
        int result = solution.maxLengthDfs(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}