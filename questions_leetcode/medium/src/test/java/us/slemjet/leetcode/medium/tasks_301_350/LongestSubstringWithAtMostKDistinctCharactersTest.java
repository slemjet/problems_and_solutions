package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class LongestSubstringWithAtMostKDistinctCharactersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("eceba", 2, 3),
                of("aa", 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int k, int expected) {
        // given
        LongestSubstringWithAtMostKDistinctCharacters solution = new LongestSubstringWithAtMostKDistinctCharacters();

        // when
        int result = solution.lengthOfLongestSubstringKDistinct(s, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}