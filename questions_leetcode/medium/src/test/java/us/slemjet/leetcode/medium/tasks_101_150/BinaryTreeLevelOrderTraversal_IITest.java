package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_101_150.BinaryTreeLevelOrderTraversal_II.TreeNode;

import java.util.List;
import java.util.stream.Stream;

class BinaryTreeLevelOrderTraversal_IITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(3,
                                new TreeNode(9, null, null),
                                new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                        List.of(List.of(15, 7), List.of(9, 20), List.of(3))),
                Arguments.of(new TreeNode(1, null, null),
                        List.of(List.of(1))),
                Arguments.of(null, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLevelOrderBottom(TreeNode root, List<List<Integer>> expected) {
        // given
        BinaryTreeLevelOrderTraversal_II solution = new BinaryTreeLevelOrderTraversal_II();

        // when
        List<List<Integer>> result = solution.levelOrderBottom(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}