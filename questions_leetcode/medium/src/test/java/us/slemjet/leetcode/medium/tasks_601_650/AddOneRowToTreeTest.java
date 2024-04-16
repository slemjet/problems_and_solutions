package us.slemjet.leetcode.medium.tasks_601_650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

class AddOneRowToTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(3),
                                        new TreeNode(1)),
                                new TreeNode(6,
                                        new TreeNode(5),
                                        null)), 1, 2,
                        new TreeNode(4,
                                new TreeNode(1,
                                        new TreeNode(2,
                                                new TreeNode(3),
                                                new TreeNode(1)),
                                        null),
                                new TreeNode(1,
                                        null,
                                        new TreeNode(6,
                                                new TreeNode(5),
                                                null)))),
                Arguments.of(new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(3),
                                        new TreeNode(1)),
                                null), 1, 3,
                        new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(1,
                                                new TreeNode(3),
                                                null),
                                        new TreeNode(1,
                                                null,
                                                new TreeNode(1))),
                                null))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int val, int depth, TreeNode expected) {
        // given
        AddOneRowToTree solution = new AddOneRowToTree();

        // when
        TreeNode result = solution.addOneRow(root, val, depth);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}