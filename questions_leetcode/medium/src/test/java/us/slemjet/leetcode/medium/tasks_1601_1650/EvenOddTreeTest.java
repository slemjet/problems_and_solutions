package us.slemjet.leetcode.medium.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

class EvenOddTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                        new TreeNode(10,
                                new TreeNode(3,
                                        new TreeNode(12),
                                        new TreeNode(8)),
                                null),
                        new TreeNode(4,
                                new TreeNode(7,
                                        new TreeNode(6),
                                        null),
                                new TreeNode(9,
                                        null,
                                        new TreeNode(2)))), true),
                Arguments.of(new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(3)),
                        new TreeNode(2,
                                new TreeNode(7),
                                null)), false),
                Arguments.of(new TreeNode(5,
                        new TreeNode(9,
                                new TreeNode(3),
                                new TreeNode(5)),
                        new TreeNode(1,
                                new TreeNode(7),
                                null)), false),
                Arguments.of(new TreeNode(2,
                        new TreeNode(12,
                                new TreeNode(5,
                                        new TreeNode(18),
                                        new TreeNode(16)),
                                new TreeNode(9)),
                        new TreeNode(8)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, boolean expected) {
        // given
        EvenOddTree solution = new EvenOddTree();

        // when
        boolean result = solution.isEvenOddTree(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}