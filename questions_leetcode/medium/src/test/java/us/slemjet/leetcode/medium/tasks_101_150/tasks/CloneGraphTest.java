package us.slemjet.leetcode.medium.tasks_101_150.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_101_150.tasks.CloneGraph.Node;

import java.util.stream.Stream;

class CloneGraphTest {

    private static Stream<Arguments> parameters() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        return Stream.of(
                Arguments.of(node1, node1),
                Arguments.of(new Node(1), new Node(1)),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCloneGraph(Node node, Node expected) {
        // given
        CloneGraph solution = new CloneGraph();

        // when
        Node value = solution.cloneGraph(node);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}