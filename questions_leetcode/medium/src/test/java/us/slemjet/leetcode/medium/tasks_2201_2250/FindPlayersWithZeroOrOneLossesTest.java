package us.slemjet.leetcode.medium.tasks_2201_2250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FindPlayersWithZeroOrOneLossesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 6}, new int[]{5, 6}, new int[]{5, 7},
                                new int[]{4, 5}, new int[]{4, 8}, new int[]{4, 9}, new int[]{10, 4}, new int[]{10, 9}},
                        List.of(List.of(1, 2, 10), List.of(4, 5, 7, 8))),
                Arguments.of(new int[][]{new int[]{2, 3}, new int[]{1, 3}, new int[]{5, 4}, new int[]{6, 4}},
                        List.of(List.of(1, 2, 5, 6), List.of())),
                Arguments.of(new int[][]{new int[]{1,100000}},
                        List.of(List.of(1), List.of(100000)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindWinners(int[][] matches, List<List<Integer>> expected) {
        // given
        FindPlayersWithZeroOrOneLosses solution = new FindPlayersWithZeroOrOneLosses();

        // when
        List<List<Integer>> result = solution.findWinners(matches);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindWinnersMap(int[][] matches, List<List<Integer>> expected) {
        // given
        FindPlayersWithZeroOrOneLosses solution = new FindPlayersWithZeroOrOneLosses();

        // when
        List<List<Integer>> result = solution.findWinnersMap(matches);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindWinnersSet(int[][] matches, List<List<Integer>> expected) {
        // given
        FindPlayersWithZeroOrOneLosses solution = new FindPlayersWithZeroOrOneLosses();

        // when
        List<List<Integer>> result = solution.findWinnersSet(matches);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}