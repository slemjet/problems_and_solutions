package us.slemjet.leetcode.medium.tasks_601_650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PalindromicSubstringsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abc", 3),
                Arguments.of("aaa", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        PalindromicSubstrings solution = new PalindromicSubstrings();

        // when
        int result = solution.countSubstrings(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}