package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SetMatrixZeroesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 1, 1},
                                new int[]{1, 0, 1},
                                new int[]{1, 1, 1}
                        },
                        new int[][]{
                                new int[]{1, 0, 1},
                                new int[]{0, 0, 0},
                                new int[]{1, 0, 1}
                        }),
                Arguments.of(new int[][]{
                                new int[]{0, 1, 2, 0},
                                new int[]{3, 4, 5, 2},
                                new int[]{1, 3, 1, 5}
                        },
                        new int[][]{
                                new int[]{0, 0, 0, 0},
                                new int[]{0, 4, 5, 0},
                                new int[]{0, 3, 1, 0}
                        }),
                Arguments.of(new int[][]{
                                new int[]{1, 2, 3, 4},
                                new int[]{5, 0, 7, 8},
                                new int[]{0, 10, 11, 12},
                                new int[]{13, 14, 15, 0}
                        },
                        new int[][]{
                                new int[]{0, 0, 3, 0},
                                new int[]{0, 0, 0, 0},
                                new int[]{0, 0, 0, 0},
                                new int[]{0, 0, 0, 0}
                        })
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void setZeroes(int[][] matrix, int[][] expected) {
        // given
        SetMatrixZeroes solution = new SetMatrixZeroes();

        // when
        solution.setZeroes(matrix);

        // then
        Assertions.assertThat(matrix).isEqualTo(expected);
    }
}
