package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static us.slemjet.leetcode.medium.tasks_51_100.BinaryTreeInorderTraversal.TreeNode;

class BinaryTreeInorderTraversalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [1,null,2,3] -> 1,3,2
                Arguments.of(
                        new TreeNode(1,
                                null,
                                new TreeNode(2,
                                        new TreeNode(3),
                                        null)), Arrays.asList(1,3,2)),
                // [] -> []
                Arguments.of(null, new ArrayList<>()),
                // [1] -> [1]
                Arguments.of(new TreeNode(1), Arrays.asList(1)),
                // [1,2] -> 2,1
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2),
                                null), Arrays.asList(2,1)),
                // [1,null,2] -> 1,2
                Arguments.of(
                        new TreeNode(1,
                                null,
                                new TreeNode(2)), Arrays.asList(1,2))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, List<Integer> expected) {
        // given
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

        // when
        List<Integer> value = solution.inorderTraversal(root);

        // then
        Assertions.assertThat(value).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionIterative(TreeNode root, List<Integer> expected) {
        // given
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

        // when
        List<Integer> value = solution.inorderTraversalIterative(root);

        // then
        Assertions.assertThat(value).containsExactlyElementsOf(expected);
    }
    
}
