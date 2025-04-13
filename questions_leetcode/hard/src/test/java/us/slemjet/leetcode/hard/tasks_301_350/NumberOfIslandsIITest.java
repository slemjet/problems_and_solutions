package us.slemjet.leetcode.hard.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class NumberOfIslandsIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, 3,
                        new int[][]{
                                new int[]{0, 0},
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{2, 1}}, List.of(1, 1, 2, 3)),
                Arguments.of(1, 1,
                        new int[][]{
                                new int[]{0, 0}}, List.of(1)),
                Arguments.of(2, 2,
                        new int[][]{
                                new int[]{0, 0},
                                new int[]{1, 1},
                                new int[]{0, 1}}, List.of(1, 2, 1)),
                Arguments.of(3, 3,
                        new int[][]{
                                new int[]{0, 0},
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{1, 2}}, List.of(1, 1, 2, 2)),
                Arguments.of(3, 3,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{2, 1},
                                new int[]{1, 0},
                                new int[]{0, 2},
                                new int[]{0, 0},
                                new int[]{1, 1}}, List.of(1, 2, 3, 4, 3, 2, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int m, int n, int[][] positions, List<Integer> expected) {
        // given
        NumberOfIslandsII solution = new NumberOfIslandsII();

        // when
        List<Integer> result = solution.numIslands2(m, n, positions);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}