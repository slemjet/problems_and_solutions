package us.slemjet.leetcode.medium.tasks_2401_2450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

class ReverseOddLevelsOfBinaryTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(8),
                                        new TreeNode(13)),
                                new TreeNode(5,
                                        new TreeNode(21),
                                        new TreeNode(34))),
                        new TreeNode(2,
                                new TreeNode(5,
                                        new TreeNode(8),
                                        new TreeNode(13)),
                                new TreeNode(3,
                                        new TreeNode(21),
                                        new TreeNode(34)))
                ),
                Arguments.of(
                        new TreeNode(7,
                                new TreeNode(13),
                                new TreeNode(11)),
                        new TreeNode(7,
                                new TreeNode(11),
                                new TreeNode(13))),
                Arguments.of(
                        new TreeNode(0,
                                new TreeNode(2,
                                        new TreeNode(0,
                                                new TreeNode(2),
                                                new TreeNode(2)),
                                        new TreeNode(0,
                                                new TreeNode(2),
                                                new TreeNode(2))),
                                new TreeNode(1,
                                        new TreeNode(0,
                                                new TreeNode(1),
                                                new TreeNode(1)),
                                        new TreeNode(0,
                                                new TreeNode(1),
                                                new TreeNode(1)))),
                        new TreeNode(0,
                                new TreeNode(1,
                                        new TreeNode(0,
                                                new TreeNode(1),
                                                new TreeNode(1)),
                                        new TreeNode(0,
                                                new TreeNode(1),
                                                new TreeNode(1))),
                                new TreeNode(2,
                                        new TreeNode(0,
                                                new TreeNode(2),
                                                new TreeNode(2)),
                                        new TreeNode(0,
                                                new TreeNode(2),
                                                new TreeNode(2))))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, TreeNode expected) {
        // given
        ReverseOddLevelsOfBinaryTree solution = new ReverseOddLevelsOfBinaryTree();

        // when
        TreeNode result = solution.reverseOddLevels(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}