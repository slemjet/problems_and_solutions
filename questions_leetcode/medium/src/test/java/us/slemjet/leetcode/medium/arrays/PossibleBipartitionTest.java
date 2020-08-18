package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PossibleBipartitionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, new int[][]{
                        new int[]{1, 2},
                        new int[]{1, 3},
                        new int[]{2, 4}}, true),
                Arguments.of(3, new int[][]{
                        new int[]{1, 2},
                        new int[]{1, 3},
                        new int[]{2, 3}}, false),
                Arguments.of(5, new int[][]{
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{3, 4},
                        new int[]{4, 5},
                        new int[]{1, 5}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void possibleBipartition(int N, int[][] dislikes, boolean expected) {
        // given
        PossibleBipartition solution = new PossibleBipartition();

        // when
        boolean result = solution.possibleBipartition(N, dislikes);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void possibleBipartitionArr(int N, int[][] dislikes, boolean expected) {
        // given
        PossibleBipartition solution = new PossibleBipartition();

        // when
        boolean result = solution.possibleBipartitionArr(N, dislikes);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
