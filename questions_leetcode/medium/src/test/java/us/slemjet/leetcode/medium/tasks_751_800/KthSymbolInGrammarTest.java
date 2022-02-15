package us.slemjet.leetcode.medium.tasks_751_800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KthSymbolInGrammarTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(2, 1, 0),
                Arguments.of(2, 2, 1),
                Arguments.of(5, 14, 1),
                Arguments.of(30, 434991989, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testKthGrammarRec(int n, int k, int expected) {
        // given
        KthSymbolInGrammar solution = new KthSymbolInGrammar();

        // when
        int result = solution.kthGrammarRec(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testKthGrammarIter(int n, int k, int expected) {
        // given
        KthSymbolInGrammar solution = new KthSymbolInGrammar();

        // when
        int result = solution.kthGrammarIter(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}