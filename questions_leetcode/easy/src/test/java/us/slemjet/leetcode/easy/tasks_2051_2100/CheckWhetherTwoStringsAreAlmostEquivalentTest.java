package us.slemjet.leetcode.easy.tasks_2051_2100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class CheckWhetherTwoStringsAreAlmostEquivalentTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("aaaa", "bccb", false),
                of("abcdeef", "abaaacc", true),
                of("cccddabba", "babababab", true),
                of("dfgcbehcifihghedhffbggdcebbbghigfhddhiigcgfeiih", "cdcgbeeceifbgchhfiffhifghiebfchbcbfhggchfbbhddb", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String word1, String word2, boolean expected) {
        // given
        CheckWhetherTwoStringsAreAlmostEquivalent solution = new CheckWhetherTwoStringsAreAlmostEquivalent();

        // when
        boolean result = solution.checkAlmostEquivalent(word1, word2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}