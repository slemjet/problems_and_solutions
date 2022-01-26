package us.slemjet.leetcode.medium.tasks_1301_1350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_1301_1350.AllElementsInTwoBinarySearchTrees.TreeNode;

import java.util.List;
import java.util.stream.Stream;

class AllElementsInTwoBinarySearchTreesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(2, new TreeNode(1), new TreeNode(4)),
                        new TreeNode(1, new TreeNode(0), new TreeNode(3)),
                        List.of(0, 1, 1, 2, 3, 4)),
                Arguments.of(
                        new TreeNode(1, null, new TreeNode(8)),
                        new TreeNode(8, new TreeNode(1), null),
                        List.of(1, 1, 8, 8))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetAllElements(TreeNode root1, TreeNode root2, List<Integer> expected) {
        // given
        AllElementsInTwoBinarySearchTrees solution = new AllElementsInTwoBinarySearchTrees();

        // when
        List<Integer> result = solution.getAllElements(root1, root2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGetAllElements2(TreeNode root1, TreeNode root2, List<Integer> expected) {
        // given
        AllElementsInTwoBinarySearchTrees solution = new AllElementsInTwoBinarySearchTrees();

        // when
        List<Integer> result = solution.getAllElements2(root1, root2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}