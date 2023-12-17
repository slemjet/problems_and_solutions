package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_51_100.UniqueBinarySearchTreesII.TreeNode;

import java.util.List;
import java.util.stream.Stream;

class UniqueBinarySearchTreesIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, List.of(new TreeNode(1))),
                Arguments.of(3, List.of(
                        new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null)),
                        new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))),
                        new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                        new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null),
                        new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, List<TreeNode> expected) {
        // given
        UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();

        // when
        List<TreeNode> result = solution.generateTrees(n);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}