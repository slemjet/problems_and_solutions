package us.slemjet.leetcode.medium.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.from_100_to_150.PopulatingNextRightPointersInEachNode.Node;

import java.util.stream.Stream;

class PopulatingNextRightPointersInEachNodeTest {

    private static Stream<Arguments> parameters() {

        Node six = new Node(6);
        Node five = new Node(5);
        Node four = new Node(4);
        Node seven = new Node(7);
        Node two = new Node(2, four, five, null);
        Node three = new Node(3, six, seven, null);
        Node one = new Node(1, two, three, null);

        two.next = three;
        four.next = five;
        five.next = six;
        six.next = seven;

        return Stream.of(
                Arguments.of(
                        new Node(1,
                                new Node(2, new Node(4), new Node(5), null),
                                new Node(3, new Node(6), new Node(7), null), null),
                        one)

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testConnect(Node root, Node expected) {
        // given
        PopulatingNextRightPointersInEachNode solution = new PopulatingNextRightPointersInEachNode();

        // when
        Node result = solution.connect(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testConnectDoubleQueues(Node root, Node expected) {
        // given
        PopulatingNextRightPointersInEachNode solution = new PopulatingNextRightPointersInEachNode();

        // when
        Node result = solution.connectDoubleQueues(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testConnectSingleQueue(Node root, Node expected) {
        // given
        PopulatingNextRightPointersInEachNode solution = new PopulatingNextRightPointersInEachNode();

        // when
        Node result = solution.connectSingleQueue(root);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
