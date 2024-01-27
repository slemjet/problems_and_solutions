package us.slemjet.leetcode.hard.from_651_to_700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KInversePairsArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, 2, 0),
                Arguments.of(3, 0, 1),
                Arguments.of(3, 1, 2),
                Arguments.of(3, 2, 2),
                Arguments.of(4, 3, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTabulation(int n, int k, int expected) {
        // given
        KInversePairsArray solution = new KInversePairsArray();

        // when
        int result = solution.kInversePairsTabulation(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionMemo(int n, int k, int expected) {
        // given
        KInversePairsArray solution = new KInversePairsArray();

        // when
        int result = solution.kInversePairsMemo(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}