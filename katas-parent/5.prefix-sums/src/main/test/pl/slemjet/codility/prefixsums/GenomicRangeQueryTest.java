package pl.slemjet.codility.prefixsums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GenomicRangeQueryTest {


    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{2, 4, 1}),
                Arguments.of("AC", new int[]{0, 0, 1}, new int[]{0, 1, 1}, new int[]{1, 1, 2}),
                Arguments.of("A", new int[]{0}, new int[]{0}, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(String S, int[] P, int[] Q, int[] expected) {
        // when
        int[] result = GenomicRangeQuery.solution(S, P, Q);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
