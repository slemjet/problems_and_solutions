package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KthSmallestElementInASortedMatrixTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [1,5,9],[10,11,13],[12,13,15] k = 8 -> 13
                Arguments.of(new int[][]{new int[]{1, 5, 9}, new int[]{10, 11, 13}, new int[]{12, 13, 15}}, 8, 13),
                // [-5], k = 1 -> -5
                Arguments.of(new int[][]{new int[]{-5}}, 1, -5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testKthSmallest(int[][] matrix, int k, int expected) {
        // given
        KthSmallestElementInASortedMatrix solution = new KthSmallestElementInASortedMatrix();

        // when
        int result = solution.kthSmallest(matrix, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testKthSmallestQueue(int[][] matrix, int k, int expected) {
        // given
        KthSmallestElementInASortedMatrix solution = new KthSmallestElementInASortedMatrix();

        // when
        int result = solution.kthSmallestQueue(matrix, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testKthSmallestQueue2(int[][] matrix, int k, int expected) {
        // given
        KthSmallestElementInASortedMatrix solution = new KthSmallestElementInASortedMatrix();

        // when
        int result = solution.kthSmallestQueue2(matrix, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}