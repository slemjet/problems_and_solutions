package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class VerifyPreorderSequenceInBinarySearchTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{5, 2, 1, 3, 6}, true),
                of(new int[]{5, 2, 6, 1, 3}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] preorder, boolean expected) {
        // given
        VerifyPreorderSequenceInBinarySearchTree solution = new VerifyPreorderSequenceInBinarySearchTree();

        // when
        boolean result = solution.verifyPreorder(preorder);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}