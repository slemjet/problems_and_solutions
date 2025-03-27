package us.slemjet.leetcode.easy.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.List;
import java.util.stream.Stream;

class BinaryTreePathsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(5)),
                                new TreeNode(3)),
                        List.of("1->2->5", "1->3")),
                Arguments.of(new TreeNode(1),
                        List.of("1"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, List<String> expected) {
        // given
        BinaryTreePaths solution = new BinaryTreePaths();

        // when
        List<String> result = solution.binaryTreePaths(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionRec(TreeNode root, List<String> expected) {
        // given
        BinaryTreePaths solution = new BinaryTreePaths();

        // when
        List<String> result = solution.binaryTreePathsRec(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}