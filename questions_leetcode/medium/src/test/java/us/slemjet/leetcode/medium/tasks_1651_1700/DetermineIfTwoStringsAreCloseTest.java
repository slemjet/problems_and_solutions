package us.slemjet.leetcode.medium.tasks_1651_1700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DetermineIfTwoStringsAreCloseTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abc", "bca", true),
                Arguments.of("a", "aa", false),
                Arguments.of("cabbba", "abbccc", true),
                Arguments.of("cabbba", "aabbss", false),
                Arguments.of("uau", "ssx", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(String word1, String word2, boolean expected) {
        // given
        DetermineIfTwoStringsAreClose solution = new DetermineIfTwoStringsAreClose();

        // when
        boolean result = solution.closeStrings(word1, word2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}