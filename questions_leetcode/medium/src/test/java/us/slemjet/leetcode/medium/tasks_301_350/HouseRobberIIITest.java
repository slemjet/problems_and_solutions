package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_301_350.HouseRobberIII.TreeNode;

import java.util.stream.Stream;

class HouseRobberIIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [3,2,3,null,3,null,1]
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(3)),
                                new TreeNode(3,
                                        null,
                                        new TreeNode(1))), 7),
                // [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(4,
                                        new TreeNode(1),
                                        new TreeNode(3)),
                                new TreeNode(5,
                                        new TreeNode(1),
                                        null)), 9),
                // [4,1,null,2,null,3]
                Arguments.of(
                        new TreeNode(4,
                                new TreeNode(1,
                                        new TreeNode(2,
                                                new TreeNode(3),
                                                null),
                                        null),
                                null), 7)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, int expected) {
        // given
        HouseRobberIII solution = new HouseRobberIII();

        // when
        int result = solution.rob(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}