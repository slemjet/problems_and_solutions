package us.slemjet.leetcode.medium.tasks_951_1000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_951_1000.KClosestPointsToOrigin;

import java.util.stream.Stream;

class KClosestPointsToOriginTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 3},
                                new int[]{-2, 2}}, 1,
                        new int[][]{
                                new int[]{-2, 2}}
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{3, 3},
                                new int[]{5, -1},
                                new int[]{-2, 4}}, 2,
                        new int[][]{
                                new int[]{-2, 4},
                                new int[]{3, 3}
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void kClosest(int[][] points, int K, int[][] expected) {
        // given
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();

        // when
        int[][] result = solution.kClosest(points, K);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
