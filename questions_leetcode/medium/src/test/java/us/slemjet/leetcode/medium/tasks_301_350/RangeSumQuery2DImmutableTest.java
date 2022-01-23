package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RangeSumQuery2DImmutableTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"NumMatrix", "sumRegion", "sumRegion", "sumRegion"},
                        new Object[]{new int[][]{
                                new int[]{3, 0, 1, 4, 2},
                                new int[]{5, 6, 3, 2, 1},
                                new int[]{1, 2, 0, 1, 5},
                                new int[]{4, 1, 0, 1, 7},
                                new int[]{1, 0, 3, 0, 5}},
                                new int[]{2, 1, 4, 3}, new int[]{1, 1, 2, 2}, new int[]{1, 2, 2, 4}},
                        new Integer[]{null, 8, 11, 12})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindMedian(String[] commands, Object[] params, Integer[] expected) {

        RangeSumQuery2DImmutable.NumMatrix numMatrix = null;
        for (int i = 0; i < commands.length; i++) {
            if ("NumMatrix".equals(commands[i])) {
                int[][] input = (int[][]) params[i];
                numMatrix = new RangeSumQuery2DImmutable.NumMatrix(input);
            } else if ("sumRegion".equals(commands[i])) {
                int[] param = (int[]) params[i];
                int result = numMatrix.sumRegion(param[0], param[1], param[2], param[3]);
                Assertions.assertThat(result).isEqualTo(expected[i]);
            }
        }
    }
}