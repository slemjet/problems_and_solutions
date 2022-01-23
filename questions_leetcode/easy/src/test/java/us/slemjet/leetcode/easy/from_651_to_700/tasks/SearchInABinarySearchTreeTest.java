package us.slemjet.leetcode.easy.from_651_to_700.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_651_to_700.tasks.SearchInABinarySearchTree.TreeNode;

import java.util.stream.Stream;

class SearchInABinarySearchTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        new TreeNode(3)),
                                new TreeNode(7)
                        ), 2,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(7)),
                Arguments.of(
                        new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        new TreeNode(3)),
                                new TreeNode(7)
                        ), 5, null)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSearchBST(TreeNode root, int val, TreeNode expected) {
        // given
        SearchInABinarySearchTree solution = new SearchInABinarySearchTree();

        // when
        TreeNode result = solution.searchBST(root, val);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}