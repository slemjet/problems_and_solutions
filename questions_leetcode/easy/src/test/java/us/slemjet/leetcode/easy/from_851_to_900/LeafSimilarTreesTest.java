package us.slemjet.leetcode.easy.from_851_to_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_851_to_900.LeafSimilarTrees.TreeNode;

import java.util.stream.Stream;

class LeafSimilarTreesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(2,
                                                new TreeNode(7),
                                                new TreeNode(4))),
                                new TreeNode(1,
                                        new TreeNode(9),
                                        new TreeNode(8))),
                        new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(7)),
                                new TreeNode(1,
                                        new TreeNode(4),
                                        new TreeNode(2,
                                                new TreeNode(9),
                                                new TreeNode(8)))),
                        true),
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3)),
                        new TreeNode(1,
                                new TreeNode(3),
                                new TreeNode(2)),
                        false),
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2),
                                null),
                        new TreeNode(2,
                                new TreeNode(2),
                                null),
                        true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testValidMountainArray(TreeNode root1, TreeNode root2, boolean expected) {
        // given
        LeafSimilarTrees solution = new LeafSimilarTrees();

        // when
        boolean result = solution.leafSimilar(root1, root2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}