package us.slemjet.leetcode.medium.tasks_1001_1050.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_1001_1050.tasks.BinarySearchTreeToGreaterSumTree.TreeNode;

import java.util.stream.Stream;

class BinarySearchTreeToGreaterSumTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(4,
                                new TreeNode(1,
                                        new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                                new TreeNode(6,
                                        new TreeNode(5), new TreeNode(7, null, new TreeNode(8)))),
                        new TreeNode(30,
                                new TreeNode(36,
                                        new TreeNode(36), new TreeNode(35, null, new TreeNode(33))),
                                new TreeNode(21,
                                        new TreeNode(26), new TreeNode(15, null, new TreeNode(8)))))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void bstToGst(TreeNode root, TreeNode expected) {
        // given
        BinarySearchTreeToGreaterSumTree solution = new BinarySearchTreeToGreaterSumTree();

        // when
        TreeNode value = solution.bstToGst(root);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}