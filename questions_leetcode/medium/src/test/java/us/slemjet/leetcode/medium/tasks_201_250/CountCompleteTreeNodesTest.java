package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_201_250.CountCompleteTreeNodes.TreeNode;

import java.util.stream.Stream;

class CountCompleteTreeNodesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3, new TreeNode(6), null)), 6),
                Arguments.of(null, 0),
                Arguments.of(new TreeNode(1), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountNodes(TreeNode root, int expected) {
        // given
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();

        // when
        int result = solution.countNodes(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountNodesOptimized(TreeNode root, int expected) {
        // given
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();

        // when
        int result = solution.countNodesOptimized(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}