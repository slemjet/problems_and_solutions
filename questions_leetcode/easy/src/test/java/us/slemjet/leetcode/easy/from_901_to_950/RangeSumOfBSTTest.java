package us.slemjet.leetcode.easy.from_901_to_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_901_to_950.RangeSumOfBST.TreeNode;

import java.util.stream.Stream;

class RangeSumOfBSTTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(10,
                                new TreeNode(5,
                                        new TreeNode(3),
                                        new TreeNode(7)),
                                new TreeNode(15,
                                        null,
                                        new TreeNode(18))),
                        7, 15, 32),
                Arguments.of(new TreeNode(10,
                                new TreeNode(5,
                                        new TreeNode(3,
                                                new TreeNode(1),
                                                null),
                                        new TreeNode(7,
                                                new TreeNode(6),
                                                null)),
                                new TreeNode(15,
                                        new TreeNode(13),
                                        new TreeNode(18))),
                        6, 10, 23)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testValidMountainArray(TreeNode root, int low, int high, int expected) {
        // given
        RangeSumOfBST solution = new RangeSumOfBST();

        // when
        int result = solution.rangeSumBST(root, low, high);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}