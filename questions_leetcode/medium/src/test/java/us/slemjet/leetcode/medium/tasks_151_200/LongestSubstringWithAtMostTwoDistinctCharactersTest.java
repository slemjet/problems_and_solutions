package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class LongestSubstringWithAtMostTwoDistinctCharactersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("eceba", 3),
                of("ccaabbb", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        LongestSubstringWithAtMostTwoDistinctCharacters solution = new LongestSubstringWithAtMostTwoDistinctCharacters();

        // when
        int result = solution.lengthOfLongestSubstringTwoDistinct(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}