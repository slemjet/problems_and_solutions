package us.slemjet.leetcode.medium.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DecodeWaysTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("10", 1),
                Arguments.of("2101", 1),
                Arguments.of("12", 2),
                Arguments.of("226", 3),
                Arguments.of("0", 0),
                Arguments.of("06", 0),
                Arguments.of("27", 1),
                Arguments.of("111111111111111111111111111111111111111111111", 1836311903)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void exist(String s, int expected) {
        // given
        DecodeWays solution = new DecodeWays();

        // when
        int result = solution.numDecodings(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void existDynamicReversed(String s, int expected) {
        // given
        DecodeWays solution = new DecodeWays();

        // when
        int result = solution.numDecodingsDynamicReversed(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void existDynamic(String s, int expected) {
        // given
        DecodeWays solution = new DecodeWays();

        // when
        int result = solution.numDecodingsDynamic(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
