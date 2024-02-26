package us.slemjet.leetcode.easy.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

class SameTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        new TreeNode(1, new TreeNode(2), new TreeNode(3)), true),
                Arguments.of(new TreeNode(1, null, new TreeNode(3)),
                        new TreeNode(1, new TreeNode(2), null), false),
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                        new TreeNode(1, new TreeNode(1), new TreeNode(2)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBFS(TreeNode p, TreeNode q, boolean expected) {
        // given
        SameTree solution = new SameTree();

        // when
        boolean result = solution.isSameTree(p, q);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}