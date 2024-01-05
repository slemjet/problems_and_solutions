package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static us.slemjet.leetcode.medium.tasks_301_350.LargestBSTSubtree.TreeNode;

class LargestBSTSubtreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [10,5,15,1,8,null,7]
                Arguments.of(
                        new TreeNode(10,
                                new TreeNode(5,
                                        new TreeNode(1),
                                        new TreeNode(8)),
                                new TreeNode(15,
                                        null,
                                        new TreeNode(7))), 3),
                // [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
                Arguments.of(
                        new TreeNode(4,
                                new TreeNode(2,
                                        new TreeNode(2,
                                                new TreeNode(2,
                                                        new TreeNode(1),
                                                        null),
                                                null),
                                        new TreeNode(3)),
                                new TreeNode(7,
                                        new TreeNode(5),
                                        null)), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int expected) {
        // given
        LargestBSTSubtree solution = new LargestBSTSubtree();

        // when
        int result = solution.largestBSTSubtree(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionPostorder(TreeNode root, int expected) {
        // given
        LargestBSTSubtree solution = new LargestBSTSubtree();

        // when
        int result = solution.largestBSTSubtreePostorder(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}