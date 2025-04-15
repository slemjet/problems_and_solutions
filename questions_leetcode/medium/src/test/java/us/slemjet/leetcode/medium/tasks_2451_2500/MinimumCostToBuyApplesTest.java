package us.slemjet.leetcode.medium.tasks_2451_2500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumCostToBuyApplesTest {


    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, new int[][]{
                        new int[]{1, 2, 4},
                        new int[]{2, 3, 2},
                        new int[]{2, 4, 5},
                        new int[]{3, 4, 1},
                        new int[]{1, 3, 4}}, new int[]{56, 42, 102, 301}, 2, new long[]{54, 42, 48, 51}),
                Arguments.of(3, new int[][]{
                        new int[]{1, 2, 5},
                        new int[]{2, 3, 1},
                        new int[]{3, 1, 2}}, new int[]{2, 3, 1}, 3, new long[]{2, 3, 1}),
                Arguments.of(8, new int[][]{
                                new int[]{8, 3, 193},
                                new int[]{4, 1, 890},
                                new int[]{8, 2, 714},
                                new int[]{7, 2, 654},
                                new int[]{6, 1, 147}},
                        new int[]{87310, 86029, 37141, 89780, 2747, 39709, 38302, 21966},
                        63, new long[]{49117, 67662, 34318, 89780, 2747, 39709, 38302, 21966})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int[][] roads, int[] appleCost, int k, long[] expected) {
        // given
        MinimumCostToBuyApples solution = new MinimumCostToBuyApples();

        // when
        long[] result = solution.minCost(n, roads, appleCost, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}