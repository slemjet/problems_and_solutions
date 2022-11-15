package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MostStonesRemovedWithSameRowOrColumnTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                //  ___________
                // | x | x |   |
                // | x |   | x |
                // |   | x | x |
                // |___|___|___|
                Arguments.of(new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 2}, new int[]{2, 1}, new int[]{2, 2}}, 5),
                //  ___________
                // | x |   | x |
                // |   | x |   |
                // | x |   | x |
                // |___|___|___|
                Arguments.of(new int[][]{new int[]{0, 0}, new int[]{0, 2}, new int[]{1, 1}, new int[]{2, 0}, new int[]{2, 2}}, 3),
                Arguments.of(new int[][]{new int[]{0, 0}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveStonesDfs(int[][] stones, int expected) {
        // given
        MostStonesRemovedWithSameRowOrColumn solution = new MostStonesRemovedWithSameRowOrColumn();

        // when
        int result = solution.removeStonesDfs(stones);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveStonesUnionFind(int[][] stones, int expected) {
        // given
        MostStonesRemovedWithSameRowOrColumn solution = new MostStonesRemovedWithSameRowOrColumn();

        // when
        int result = solution.removeStonesUnionFind(stones);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}