package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_101_150.CopyListWithRandomPointer.Node;

import java.util.stream.Stream;

class CopyListWithRandomPointerTest {

    private static Stream<Arguments> parameters() {

        Node node1_0 = new Node(7);
        Node node1_1 = new Node(13);
        Node node1_2 = new Node(11);
        Node node1_3 = new Node(10);
        Node node1_4 = new Node(1);

        node1_0.next = node1_1;
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;

        node1_1.random = node1_0;
        node1_2.random = node1_4;
        node1_3.random = node1_2;
        node1_4.random = node1_0;

        Node node2_0 = new Node(3);
        Node node2_1 = new Node(3);
        Node node2_2 = new Node(3);

        node2_0.next = node2_1;
        node2_1.next = node2_2;

        node2_1.random = node2_0;

        Node node3_0 = new Node(-1);

        return Stream.of(
                // [[7,null],[13,0],[11,4],[10,2],[1,0]]
                Arguments.of(node1_0, node1_0),
                // [[3,null],[3,0],[3,null]]
                Arguments.of(node2_0, node2_0),
                // [[-1,null]]
                Arguments.of(node3_0, node3_0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCopyRandomList(Node head, Node expected) {
        // given
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        // when
        Node result = solution.copyRandomList(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
