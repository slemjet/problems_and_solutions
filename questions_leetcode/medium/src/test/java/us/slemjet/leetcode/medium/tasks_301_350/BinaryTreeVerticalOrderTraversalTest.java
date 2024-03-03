package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.List;
import java.util.stream.Stream;

class BinaryTreeVerticalOrderTraversalTest {


    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(3,
                                new TreeNode(9),
                                new TreeNode(20,
                                        new TreeNode(15),
                                        new TreeNode(7))),
                        List.of(List.of(9), List.of(3, 15), List.of(20), List.of(7))),
                Arguments.of(new TreeNode(3,
                                new TreeNode(9,
                                        new TreeNode(4),
                                        new TreeNode(0)),
                                new TreeNode(8,
                                        new TreeNode(1),
                                        new TreeNode(7))),
                        List.of(List.of(4), List.of(9), List.of(3, 0, 1), List.of(8), List.of(7))),
                Arguments.of(new TreeNode(3,
                                new TreeNode(9,
                                        new TreeNode(4),
                                        new TreeNode(0,
                                                new TreeNode(5),
                                                null)),
                                new TreeNode(8,
                                        new TreeNode(1,
                                                null,
                                                new TreeNode(2)),
                                        new TreeNode(7))),
                        List.of(List.of(4), List.of(9, 5), List.of(3, 0, 1), List.of(8, 2), List.of(7)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, List<List<Integer>> expected) {
        // given
        BinaryTreeVerticalOrderTraversal solution = new BinaryTreeVerticalOrderTraversal();

        // when
        List<List<Integer>> result = solution.verticalOrder(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}