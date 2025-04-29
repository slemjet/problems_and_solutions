package us.slemjet.leetcode.easy.tasks_651_700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountBinarySubstringsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("00110011", 6),
                Arguments.of("10101", 4),
                Arguments.of("0", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionGroups(String s, int expected) {
        // given
        CountBinarySubstrings solution = new CountBinarySubstrings();

        // when
        int result = solution.countBinarySubstringsCountGroups(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionLinear(String s, int expected) {
        // given
        CountBinarySubstrings solution = new CountBinarySubstrings();

        // when
        int result = solution.countBinarySubstringsLinear(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}