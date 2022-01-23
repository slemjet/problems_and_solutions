package us.slemjet.leetcode.medium.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_701_750.InsertIntoABinarySearchTree.TreeNode;

import java.util.stream.Stream;


class InsertIntoABinarySearchTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(4,
                                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                                new TreeNode(7)), 5,
                        new TreeNode[]{
                                new TreeNode(4,
                                        new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                                        new TreeNode(7, new TreeNode(5), null)),
                                new TreeNode(5,
                                        new TreeNode(2,
                                                new TreeNode(1),
                                                new TreeNode(3, null, new TreeNode(4))),
                                        new TreeNode(7))
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testInsertIntoBST(TreeNode root, int val, TreeNode[] expected) {
        // given
        InsertIntoABinarySearchTree solution = new InsertIntoABinarySearchTree();

        // when
        TreeNode result = solution.insertIntoBST(root, val);

        // then
        Assertions.assertThat(result).isIn(expected);
    }
}