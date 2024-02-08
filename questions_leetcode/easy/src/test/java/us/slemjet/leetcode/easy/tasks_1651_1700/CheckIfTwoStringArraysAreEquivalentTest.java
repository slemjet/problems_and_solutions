package us.slemjet.leetcode.easy.tasks_1651_1700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CheckIfTwoStringArraysAreEquivalentTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"ab", "c"}, new String[]{"a", "bc"}, true),
                Arguments.of(new String[]{"a", "cb"}, new String[]{"ab", "c"}, false),
                Arguments.of(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}, true),
                Arguments.of(new String[]{"ab", "c"}, new String[]{"a", "bcd"}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] word1, String[] word2, boolean expected) {
        // given
        CheckIfTwoStringArraysAreEquivalent solution = new CheckIfTwoStringArraysAreEquivalent();

        // when
        boolean result = solution.arrayStringsAreEqual(word1, word2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}