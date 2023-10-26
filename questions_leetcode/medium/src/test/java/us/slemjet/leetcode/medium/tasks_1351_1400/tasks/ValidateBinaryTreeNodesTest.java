package us.slemjet.leetcode.medium.tasks_1351_1400.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidateBinaryTreeNodesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}, true),
                Arguments.of(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}, false),
                Arguments.of(2, new int[]{1, 0}, new int[]{-1, -1}, false),
                Arguments.of(6, new int[]{1, -1, -1, 4, -1, -1}, new int[]{2, -1, -1, 5, -1, -1}, false),
                Arguments.of(4, new int[]{3, -1, 1, -1}, new int[]{-1, -1, 0, -1}, true),
                Arguments.of(4, new int[]{1, 2, 0, -1}, new int[]{-1, -1, -1, -1}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild, boolean expected) {
        // given
        ValidateBinaryTreeNodes solution = new ValidateBinaryTreeNodes();

        // when
        boolean result = solution.validateBinaryTreeNodes(n, leftChild, rightChild);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}