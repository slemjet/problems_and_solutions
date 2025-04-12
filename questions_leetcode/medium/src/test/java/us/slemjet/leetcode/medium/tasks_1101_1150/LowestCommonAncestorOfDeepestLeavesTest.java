package us.slemjet.leetcode.medium.tasks_1101_1150;

import com.sun.source.tree.Tree;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

class LowestCommonAncestorOfDeepestLeavesTest {

    private static Stream<Arguments> parameters() {
        TreeNode answer1 = new TreeNode(2,
                new TreeNode(7),
                new TreeNode(4));
        TreeNode answer2 = new TreeNode(1);
        TreeNode answer3 = new TreeNode(2);
        TreeNode answer4 = new TreeNode(2,
                new TreeNode(3,
                        null,
                        new TreeNode(6)),
                new TreeNode(4,
                        null,
                        new TreeNode(5)));
        return Stream.of(
                Arguments.of(new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(6),
                                        answer1),
                                new TreeNode(1,
                                        new TreeNode(0),
                                        new TreeNode(8))),
                        answer1),
                Arguments.of(answer2, answer2),
                Arguments.of(new TreeNode(0,
                        new TreeNode(1,
                                null,
                                answer3),
                        new TreeNode(3)), answer3),
                Arguments.of(answer4, answer4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsRobotBounded(TreeNode root, TreeNode expected) {
        // given
        LowestCommonAncestorOfDeepestLeaves solution = new LowestCommonAncestorOfDeepestLeaves();

        // when
        TreeNode result = solution.lcaDeepestLeaves(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsRobotBounded2(TreeNode root, TreeNode expected) {
        // given
        LowestCommonAncestorOfDeepestLeaves solution = new LowestCommonAncestorOfDeepestLeaves();

        // when
        TreeNode result = solution.lcaDeepestLeaves2(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}