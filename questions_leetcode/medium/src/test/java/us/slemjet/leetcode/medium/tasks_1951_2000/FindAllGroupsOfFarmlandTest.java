package us.slemjet.leetcode.medium.tasks_1951_2000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindAllGroupsOfFarmlandTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 0, 0},
                                new int[]{0, 1, 1},
                                new int[]{0, 1, 1}},
                        new int[][]{
                                new int[]{0, 0, 0, 0},
                                new int[]{1, 1, 2, 2}
                        }),
                Arguments.of(
                        new int[][]{
                                new int[]{1, 1},
                                new int[]{1, 1}},
                        new int[][]{
                                new int[]{0, 0, 1, 1}
                        }),
                Arguments.of(
                        new int[][]{
                                new int[]{0}},
                        new int[][]{}),
                Arguments.of(
                        new int[][]{
                                new int[]{1, 1, 0, 0, 0, 1},
                                new int[]{1, 1, 0, 0, 0, 0}},
                        new int[][]{
                                new int[]{0, 0, 1, 1},
                                new int[]{0, 5, 0, 5},
                        })
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] land, int[][] expected) {
        // given
        FindAllGroupsOfFarmland solution = new FindAllGroupsOfFarmland();

        // when
        int[][] result = solution.findFarmland(land);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}