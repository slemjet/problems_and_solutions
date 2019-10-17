package us.slemjet.leetcode.easy.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
                Arguments.of(new String[]{}, ""),
                Arguments.of(new String[]{"a"}, "a"),
                Arguments.of(new String[]{"c", "c"}, "c")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void reverseTest(String[] strs, String expected) {
        // given
        LongestCommonPrefix solution = new LongestCommonPrefix();

        // when
        String prefix = solution.longestCommonPrefix(strs);

        // then
        Assertions.assertThat(prefix).isEqualTo(expected);
    }
}