package us.slemjet.leetcode.medium.tasks_1901_1950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniqueLength3PalindromicSubsequencesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aabca", 3),
                Arguments.of("adc", 0),
                Arguments.of("bbcbaba", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        UniqueLength3PalindromicSubsequences solution = new UniqueLength3PalindromicSubsequences();

        // when
        int result = solution.countPalindromicSubsequence(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}