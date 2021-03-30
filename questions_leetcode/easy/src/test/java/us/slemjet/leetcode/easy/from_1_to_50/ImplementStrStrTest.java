package us.slemjet.leetcode.easy.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ImplementStrStrTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("hello", "ll", 2),
                Arguments.of("aaaaa", "bba", -1),
                Arguments.of("", "", 0),
                Arguments.of("a", "a", 0),
                Arguments.of("erhshfghjhghjdssdgg", "ghjhghjd", 6),
                Arguments.of("adsgwadsxdsgwadsgz", "dsgwadsgz", 9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void strStr(String haystack, String needle, int expected) {
        // given
        ImplementStrStr solution = new ImplementStrStr();

        // when
        int result = solution.strStr(haystack, needle);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void strStr2(String haystack, String needle, int expected) {
        // given
        ImplementStrStr solution = new ImplementStrStr();

        // when
        int result = solution.strStr2(haystack, needle);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
