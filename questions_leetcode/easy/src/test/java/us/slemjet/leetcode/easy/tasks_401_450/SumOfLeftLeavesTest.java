package us.slemjet.leetcode.easy.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class SumOfLeftLeavesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7))), 24),
                of(new TreeNode(1), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int expected) {
        // given
        SumOfLeftLeaves solution = new SumOfLeftLeaves();

        // when
        int result = solution.sumOfLeftLeaves(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}