package us.slemjet.leetcode.medium.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

class FindBottomLeftTreeValueTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)), 1),
                Arguments.of(new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                null),
                        new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(7),
                                        null),
                                new TreeNode(6))), 7)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBFS(TreeNode root, int expected) {
        // given
        FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();

        // when
        int result = solution.findBottomLeftValueBFS(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDFSRecursion(TreeNode root, int expected) {
        // given
        FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();

        // when
        int result = solution.findBottomLeftValueDFSRecursion(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDFSStack(TreeNode root, int expected) {
        // given
        FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();

        // when
        int result = solution.findBottomLeftValueDFSStack(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}