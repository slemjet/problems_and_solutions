package us.slemjet.leetcode.medium.tasks_1701_1750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WhereWillTheBallFallTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                //   0 1 2 3 4
                // | \ \ \ / / |
                // | \ \ \ / / |
                // | / / / \ \ |
                // | \ \ \ \ / |
                // | / / / / / |
                Arguments.of(new int[][]{
                                new int[]{1, 1, 1, -1, -1},
                                new int[]{1, 1, 1, -1, -1},
                                new int[]{-1, -1, -1, 1, 1},
                                new int[]{1, 1, 1, 1, -1},
                                new int[]{-1, -1, -1, -1, -1}},
                        new int[]{1, -1, -1, -1, -1}),
                //   0
                // | / |
                //  -1
                Arguments.of(new int[][]{new int[]{-1}},
                        new int[]{-1}),
                //   0  1  2  3  4
                // | \  \  \  \  \ |
                // | /  /  /  /  / |
                // | \  \  \  \  \ |
                // | /  /  /  /  / |
                //    0  1  2  3 -1
                Arguments.of(new int[][]{
                                new int[]{1, 1, 1, 1, 1, 1},
                                new int[]{-1, -1, -1, -1, -1, -1},
                                new int[]{1, 1, 1, 1, 1, 1},
                                new int[]{-1, -1, -1, -1, -1, -1}},
                        new int[]{0, 1, 2, 3, 4, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindBall(int[][] gridInts, int[] expected) {
        // given
        WhereWillTheBallFall solution = new WhereWillTheBallFall();

        // when
        int[] result = solution.findBall(gridInts);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}