package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.List;
import java.util.stream.Stream;

class BinaryTreeRightSideViewTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(5)),
                                new TreeNode(3,
                                        null,
                                        new TreeNode(4))),
                        List.of(1, 3, 4)),
                Arguments.of(new TreeNode(1,
                                null,
                                new TreeNode(3)),
                        List.of(1, 3)),
                Arguments.of(null, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBFS(TreeNode root, List<Integer> expected) {
        // given
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();

        // when
        List<Integer> value = solution.rightSideViewBFS(root);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDFS(TreeNode root, List<Integer> expected) {
        // given
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();

        // when
        List<Integer> value = solution.rightSideViewDFS(root);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}