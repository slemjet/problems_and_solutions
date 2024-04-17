package us.slemjet.leetcode.medium.tasks_851_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.stream.Stream;

class SmallestStringStartingFromLeafTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(0,
                        new TreeNode(1,
                                new TreeNode(3),
                                new TreeNode(4)),
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4))), "dba"),
                Arguments.of(new TreeNode(25,
                        new TreeNode(1,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(3,
                                new TreeNode(0),
                                new TreeNode(2))), "adz"),
                Arguments.of(new TreeNode(2,
                        new TreeNode(2,
                                null,
                                new TreeNode(1,
                                        new TreeNode(0),
                                        null)),
                        new TreeNode(1,
                                new TreeNode(0),
                                null)), "abc"),
                Arguments.of(new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7))), "hud")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, String expected) {
        // given
        SmallestStringStartingFromLeaf solution = new SmallestStringStartingFromLeaf();

        // when
        String result = solution.smallestFromLeaf(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}