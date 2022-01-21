package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static us.slemjet.leetcode.medium.tasks_101_150.BinaryTreeLevelOrderTraversal.TreeNode;

class BinaryTreeLevelOrderTraversalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [3,9,20,null,null,15,7] -> [3],[9,20],[15,7]
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(9, null,null),
                                new TreeNode(20,
                                        new TreeNode(15), new TreeNode(7))),
                        Arrays.asList(Collections.singletonList(3), Arrays.asList(9 , 20), Arrays.asList(15, 7))),
                // [[1,2,3,4,null,null,5]] -> [[1],[2,3],[4,5]]
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2, new TreeNode(4),null),
                                new TreeNode(3,null, new TreeNode(5))),
                        Arrays.asList(Collections.singletonList(1), Arrays.asList(2 , 3), Arrays.asList(4, 5))),
                // [] -> []
                Arguments.of(
                        null, new ArrayList<>())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLevelOrder(TreeNode root, List<List<Integer>> expected) {
        // given
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

        // when
        List<List<Integer>> result = solution.levelOrder(root);

        // then
        Assertions.assertThat(result).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLevelOrderQueue(TreeNode root, List<List<Integer>> expected) {
        // given
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

        // when
        List<List<Integer>> result = solution.levelOrderQueue(root);

        // then
        Assertions.assertThat(result).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLevelOrderQueue2(TreeNode root, List<List<Integer>> expected) {
        // given
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

        // when
        List<List<Integer>> result = solution.levelOrder2Queue(root);

        // then
        Assertions.assertThat(result).containsExactlyElementsOf(expected);
    }

}
