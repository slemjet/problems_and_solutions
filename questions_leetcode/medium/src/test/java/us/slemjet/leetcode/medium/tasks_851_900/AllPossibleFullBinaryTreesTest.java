package us.slemjet.leetcode.medium.tasks_851_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_851_900.AllPossibleFullBinaryTrees.TreeNode;

import java.util.List;
import java.util.stream.Stream;

class AllPossibleFullBinaryTreesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(7, List.of(
                                new TreeNode(0,
                                        new TreeNode(0),
                                        new TreeNode(0,
                                                new TreeNode(0),
                                                new TreeNode(0,
                                                        new TreeNode(0),
                                                        new TreeNode(0)))),
                                new TreeNode(0,
                                        new TreeNode(0),
                                        new TreeNode(0,
                                                new TreeNode(0,
                                                        new TreeNode(0),
                                                        new TreeNode(0)),
                                                new TreeNode(0))),
                                new TreeNode(0,
                                        new TreeNode(0,
                                                new TreeNode(0),
                                                new TreeNode(0)),
                                        new TreeNode(0,
                                                new TreeNode(0),
                                                new TreeNode(0))),
                                new TreeNode(0,
                                        new TreeNode(0,
                                                new TreeNode(0),
                                                new TreeNode(0,
                                                        new TreeNode(0),
                                                        new TreeNode(0))),
                                        new TreeNode(0)),
                                new TreeNode(0,
                                        new TreeNode(0,
                                                new TreeNode(0,
                                                        new TreeNode(0),
                                                        new TreeNode(0)),
                                                new TreeNode(0)),
                                        new TreeNode(0))
                        )
                ),
                Arguments.of(3, List.of(new TreeNode(0, new TreeNode(0), new TreeNode(0))))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testAllPossibleFBT(int n, List<TreeNode> expected) {
        // given
        AllPossibleFullBinaryTrees solution = new AllPossibleFullBinaryTrees();

        // when
        List<TreeNode> result = solution.allPossibleFBT(n);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}