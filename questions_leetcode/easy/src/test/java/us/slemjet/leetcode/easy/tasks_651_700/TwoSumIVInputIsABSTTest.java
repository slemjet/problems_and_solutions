package us.slemjet.leetcode.easy.tasks_651_700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tasks_651_700.TwoSumIVInputIsABST.TreeNode;

import java.util.stream.Stream;

class TwoSumIVInputIsABSTTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // 5,3,6,2,4,null,7 -> 9
                Arguments.of(new TreeNode(5,
                        new TreeNode(3, new TreeNode(6), new TreeNode(2)),
                        new TreeNode(6, null, new TreeNode(7))), 9, true),
                // 5,3,6,2,4,null,7 -> 28
                Arguments.of(new TreeNode(5,
                        new TreeNode(3, new TreeNode(6), new TreeNode(2)),
                        new TreeNode(6, null, new TreeNode(7))), 28, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindTarget(TreeNode root, int k, boolean expected) {
        // given
        TwoSumIVInputIsABST solution = new TwoSumIVInputIsABST();

        // when
        boolean result = solution.findTarget(root, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindTargetBinary(TreeNode root, int k, boolean expected) {
        // given
        TwoSumIVInputIsABST solution = new TwoSumIVInputIsABST();

        // when
        boolean result = solution.findTargetBinary(root, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}