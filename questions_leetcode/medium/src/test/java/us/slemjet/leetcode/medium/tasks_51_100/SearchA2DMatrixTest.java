package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchA2DMatrixTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 3, 5, 7},
                        new int[]{10, 11, 16, 20},
                        new int[]{23, 30, 34, 60}}, 3, true),
                Arguments.of(new int[][]{
                        new int[]{1, 3, 5, 7},
                        new int[]{10, 11, 16, 20},
                        new int[]{23, 30, 34, 60}}, 13, false),
                Arguments.of(new int[][]{
                        new int[]{1}}, 2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSearchMatrix(int[][] matrix, int target, boolean expected) {
        // given
        SearchA2DMatrix solution = new SearchA2DMatrix();

        // when
        boolean result = solution.searchMatrix(matrix, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}