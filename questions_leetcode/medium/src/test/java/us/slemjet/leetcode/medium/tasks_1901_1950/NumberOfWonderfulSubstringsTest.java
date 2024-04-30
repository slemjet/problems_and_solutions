package us.slemjet.leetcode.medium.tasks_1901_1950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfWonderfulSubstringsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aba", 4),
                Arguments.of("aabb", 9),
                Arguments.of("he", 2),
                Arguments.of("feffaec", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String word, long expected) {
        // given
        NumberOfWonderfulSubstrings solution = new NumberOfWonderfulSubstrings();

        // when
        long result = solution.wonderfulSubstrings(word);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}