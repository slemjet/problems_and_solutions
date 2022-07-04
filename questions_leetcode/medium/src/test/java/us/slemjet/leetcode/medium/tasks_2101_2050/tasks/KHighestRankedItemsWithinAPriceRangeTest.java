package us.slemjet.leetcode.medium.tasks_2101_2050.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class KHighestRankedItemsWithinAPriceRangeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 2, 0, 1},
                        new int[]{1, 3, 3, 1},
                        new int[]{0, 2, 5, 1},
                }, new int[]{2, 5}, new int[]{0, 0}, 3, List.of(List.of(0, 1), List.of(1, 1), List.of(2, 1))),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 0, 1},
                        new int[]{1, 3, 3, 1},
                        new int[]{0, 2, 5, 1},
                }, new int[]{2, 3}, new int[]{2, 3}, 2, List.of(List.of(2, 1), List.of(1, 2))),
                Arguments.of(new int[][]{
                        new int[]{1, 1, 1},
                        new int[]{0, 0, 1},
                        new int[]{2, 3, 4},
                }, new int[]{2, 3}, new int[]{0, 0}, 3, List.of(List.of(2, 1), List.of(2, 0))),
                Arguments.of(new int[][]{
                        new int[]{2, 0, 2},
                        new int[]{4, 5, 3},
                        new int[]{2, 0, 2},
                }, new int[]{2, 5}, new int[]{1, 1}, 9, List.of(List.of(1, 1), List.of(1, 2), List.of(1, 0), List.of(0, 0), List.of(0, 2), List.of(2, 0), List.of(2, 2)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testHighestRankedKItems(int[][] grid, int[] pricing, int[] start, int k, List<List<Integer>> expected) {
        // given
        KHighestRankedItemsWithinAPriceRange solution = new KHighestRankedItemsWithinAPriceRange();

        // when
        List<List<Integer>> result = solution.highestRankedKItems(grid, pricing, start, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}