package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_101_150.BinaryTreePostorderTraversal.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class BinaryTreePostorderTraversalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [1,null,2,3] -> 1,3,2
                Arguments.of(
                        new TreeNode(1,
                                null,
                                new TreeNode(2,
                                        new TreeNode(3),
                                        null)), Arrays.asList(3, 2, 1)),
                // [] -> []
                Arguments.of(null, new ArrayList<>()),
                // [1] -> [1]
                Arguments.of(new TreeNode(1), Arrays.asList(1)),
                // [3, 1, 2] -> 1, 2, 3
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(1),
                                new TreeNode(2)), Arrays.asList(1, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testPostorderTraversal(TreeNode root, List<Integer> expected) {
        // given
        BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();

        // when
        List<Integer> value = solution.postorderTraversal(root);

        // then
        Assertions.assertThat(value).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testPostorderTraversalIterative(TreeNode root, List<Integer> expected) {
        // given
        BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();

        // when
        List<Integer> value = solution.postorderTraversalIterative(root);

        // then
        Assertions.assertThat(value).containsExactlyElementsOf(expected);
    }
}