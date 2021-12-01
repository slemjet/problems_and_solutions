package us.slemjet.leetcode.hard.from_201_to_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class TheSkylineProblemTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]] -> [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
                Arguments.of(new int[][]{
                                new int[]{2, 9, 10},
                                new int[]{3, 7, 15},
                                new int[]{5, 12, 12},
                                new int[]{15, 20, 10},
                                new int[]{19, 24, 8}
                        },
                        asList(
                                asList(2, 10),
                                asList(3, 15),
                                asList(7, 12),
                                asList(12, 0),
                                asList(15, 10),
                                asList(20, 8),
                                asList(24, 0))),
                // [[0,2,3],[2,5,3]] -> [[0,3],[5,0]]
                Arguments.of(new int[][]{new int[]{0, 2, 3}, new int[]{2, 5, 3}},
                        asList(asList(0, 3), asList(5, 0))),
                // [[2,9,10],[9,12,15]] -> [[2,10],[9,15],[12,0]]
                Arguments.of(new int[][]{new int[]{2, 9, 10}, new int[]{9, 12, 15}},
                        asList(asList(2, 10), asList(9, 15), asList(12, 0))),
                // [[1,2,1],[1,2,2],[1,2,3]] -> [[1,3],[2,0]]
                Arguments.of(new int[][]{new int[]{1, 2, 1}, new int[]{1, 2, 2}, new int[]{1, 2, 3}},
                        asList(asList(1, 3), asList(2, 0))),
                // [[0,2,3],[2,4,3],[4,6,3]] -> [[0,3],[6,0]]
                Arguments.of(new int[][]{new int[]{0, 2, 3}, new int[]{2, 4, 3}, new int[]{4, 6, 3}},
                        asList(asList(0, 3), asList(6, 0)))

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindWords(int[][] buildings, List<List<Integer>> expected) {
        // given
        TheSkylineProblem solution = new TheSkylineProblem();

        // when
        List<List<Integer>> result = solution.getSkyline(buildings);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}