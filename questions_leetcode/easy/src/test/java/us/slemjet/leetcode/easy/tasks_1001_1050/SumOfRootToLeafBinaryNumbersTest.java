package us.slemjet.leetcode.easy.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tasks_1001_1050.SumOfRootToLeafBinaryNumbers.TreeNode;

import java.util.stream.Stream;

class SumOfRootToLeafBinaryNumbersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(0,
                                        new TreeNode(0),
                                        new TreeNode(1)),
                                new TreeNode(1,
                                        new TreeNode(0),
                                        new TreeNode(1))), 22),
                Arguments.of(new TreeNode(0), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSumRootToLeaf(TreeNode root, int expected) {
        // given
        SumOfRootToLeafBinaryNumbers solution = new SumOfRootToLeafBinaryNumbers();

        // when
        int result = solution.sumRootToLeaf(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSumRootToLeaf2(TreeNode root, int expected) {
        // given
        SumOfRootToLeafBinaryNumbers solution = new SumOfRootToLeafBinaryNumbers();

        // when
        int result = solution.sumRootToLeaf2(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}