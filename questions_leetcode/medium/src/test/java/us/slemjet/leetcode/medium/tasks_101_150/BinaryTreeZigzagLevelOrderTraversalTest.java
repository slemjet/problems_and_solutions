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

import static us.slemjet.leetcode.medium.tasks_101_150.BinaryTreeZigzagLevelOrderTraversal.TreeNode;

class BinaryTreeZigzagLevelOrderTraversalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [3,9,20,null,null,15,7] -> [3],[9,20],[15,7]
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(9, null, null),
                                new TreeNode(20,
                                        new TreeNode(15), new TreeNode(7))),
                        Arrays.asList(Collections.singletonList(3), Arrays.asList(20, 9), Arrays.asList(15, 7))),
                // [1] -> [1]
                Arguments.of(
                        new TreeNode(1), Collections.singletonList(Collections.singletonList(1))),
                // [] -> []
                Arguments.of(
                        null, new ArrayList<>())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testZigzagLevelOrder(TreeNode root, List<List<Integer>> expected) {
        // given
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();

        // when
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // then
        Assertions.assertThat(result).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testZigzagLevelOrder2Queue(TreeNode root, List<List<Integer>> expected) {
        // given
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();

        // when
        List<List<Integer>> result = solution.zigzagLevelOrder2Queue(root);

        // then
        Assertions.assertThat(result).containsExactlyElementsOf(expected);
    }

}
