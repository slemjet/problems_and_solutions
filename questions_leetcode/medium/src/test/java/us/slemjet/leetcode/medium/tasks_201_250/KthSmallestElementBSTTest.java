package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_201_250.KthSmallestElementBST;
import us.slemjet.leetcode.medium.tasks_201_250.KthSmallestElementBST.TreeNode;

import java.util.stream.Stream;

class KthSmallestElementBSTTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(1, null, new TreeNode(2)),
                                new TreeNode(4)), 1, 1), // [3,1,4,null,2], k = 1 -> 1

                Arguments.of(
                        new TreeNode(5,
                                new TreeNode(3,
                                        new TreeNode(2,
                                                new TreeNode(1), null),
                                        new TreeNode(4)),
                                new TreeNode(6)), 3, 3) // [5,3,6,2,4,null,null,1], k = 3 -> 3
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int k, int expected) {
        // given
        KthSmallestElementBST solution = new KthSmallestElementBST();

        // when
        int value = solution.kthSmallest(root, k);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionNumber(TreeNode root, int k, int expected) {
        // given
        KthSmallestElementBST solution = new KthSmallestElementBST();

        // when
        int value = solution.kthSmallestNumber(root, k);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}
