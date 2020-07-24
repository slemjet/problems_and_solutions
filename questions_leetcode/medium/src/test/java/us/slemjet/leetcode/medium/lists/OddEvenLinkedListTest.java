package us.slemjet.leetcode.medium.lists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.lists.OddEvenLinkedList.ListNode;

import java.util.stream.Stream;

class OddEvenLinkedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL
                Arguments.of(createListNode(1, 2, 3, 4, 5), createListNode(1, 3, 5, 2, 4)),
                // Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
                Arguments.of(createListNode(2, 1, 3, 5, 6, 4, 7), createListNode(2, 3, 6, 7, 1, 5, 4)),
                Arguments.of(createListNode(1, 2, 3, 4, 5, 6, 7), createListNode(1, 3, 5, 7, 2, 4, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void oddEvenList(ListNode node, ListNode expected) {
        // given
        OddEvenLinkedList solution = new OddEvenLinkedList();

        // when
        ListNode result = solution.oddEvenList(node);

        // then

        while (expected != null){
            Assertions.assertThat(result.val).isEqualTo(expected.val);
            expected = expected.next;
            result = result.next;
        }
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void oddEvenListMy(ListNode node, ListNode expected) {
        // given
        OddEvenLinkedList solution = new OddEvenLinkedList();

        // when
        ListNode result = solution.oddEvenListMy(node);

        // then

        while (expected != null){
            Assertions.assertThat(result.val).isEqualTo(expected.val);
            expected = expected.next;
            result = result.next;
        }
        Assertions.assertThat(result).isEqualTo(expected);
    }

    static ListNode createListNode(int... values) {
        ListNode root = new ListNode(values[0]);
        ListNode node = new ListNode(values[1]);
        root.next = node;

        for (int i = 2; i < values.length; i++) {
            ListNode nextNode = new ListNode(values[i]);
            node.next = nextNode;
            node = nextNode;
        }

        return root;
    }
}
