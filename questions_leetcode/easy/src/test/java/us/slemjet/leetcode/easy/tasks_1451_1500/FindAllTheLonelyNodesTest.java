package us.slemjet.leetcode.easy.tasks_1451_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.TreeNode;

import java.util.List;
import java.util.stream.Stream;

class FindAllTheLonelyNodesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                        new TreeNode(2,
                                null,
                                new TreeNode(4)),
                        new TreeNode(3)), List.of(4)),
                Arguments.of(new TreeNode(7,
                        new TreeNode(1,
                                new TreeNode(6),
                                null),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(3,
                                        null,
                                        new TreeNode(2)))), List.of(6, 2)),
                Arguments.of(new TreeNode(11,
                        new TreeNode(99,
                                new TreeNode(77,
                                        new TreeNode(55,
                                                new TreeNode(33),
                                                null),
                                        null),
                                null),
                        new TreeNode(88,
                                null,
                                new TreeNode(66,
                                        null,
                                        new TreeNode(44,
                                                null,
                                                new TreeNode(22))))), List.of(77, 55, 33, 66, 44, 22))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(TreeNode root, List<Integer> expected) {
        // given
        FindAllTheLonelyNodes solution = new FindAllTheLonelyNodes();

        // when
        List<Integer> result = solution.getLonelyNodes(root);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}