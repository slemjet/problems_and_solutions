package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IntervalListIntersectionsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{0, 2},
                                new int[]{5, 10},
                                new int[]{13, 23},
                                new int[]{24, 25}
                        }, new int[][]{
                                new int[]{1, 5},
                                new int[]{8, 12},
                                new int[]{15, 24},
                                new int[]{25, 26}
                        }, new int[][]{
                                new int[]{1, 2},
                                new int[]{5, 5},
                                new int[]{8, 10},
                                new int[]{15, 23},
                                new int[]{24, 24},
                                new int[]{25, 25}
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void intervalIntersection(int[][] A, int[][] B, int[][] expected) {
        // given
        IntervalListIntersections solution = new IntervalListIntersections();

        // when
        int[][] result = solution.intervalIntersection(A, B);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
