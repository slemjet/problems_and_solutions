package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchA2DMatrixIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 4, 7, 11, 15},
                        new int[]{2, 5, 8, 12, 19},
                        new int[]{3, 6, 9, 16, 22},
                        new int[]{10, 13, 14, 17, 24},
                        new int[]{18, 21, 23, 26, 30}}, 5, true),
                Arguments.of(new int[][]{
                        new int[]{1, 4, 7, 11, 15},
                        new int[]{2, 5, 8, 12, 19},
                        new int[]{3, 6, 9, 16, 22},
                        new int[]{10, 13, 14, 17, 24},
                        new int[]{18, 21, 23, 26, 30}}, 20, false),
                Arguments.of(new int[][]{new int[]{-1, 3}}, 3, true),
                Arguments.of(new int[][]{new int[]{1, 1}}, 2, false),
                Arguments.of(new int[][]{new int[]{1, 4}, new int[]{2, 5}}, 2, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSearchMatrix(int[][] matrix, int target, boolean expected) {
        // given
        SearchA2DMatrixII solution = new SearchA2DMatrixII();

        // when
        boolean result = solution.searchMatrix(matrix, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}