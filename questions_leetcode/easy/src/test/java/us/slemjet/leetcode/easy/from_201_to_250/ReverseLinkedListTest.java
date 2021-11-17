package us.slemjet.leetcode.easy.from_201_to_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static us.slemjet.leetcode.easy.from_201_to_250.ReverseLinkedList.ListNode;

class ReverseLinkedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // Input: head = [1,2,3,4,5] -> [5,4,3,2,1]
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                        new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))),
                // Input: head = [1,2] -> [2,1]
                Arguments.of(
                        new ListNode(1, new ListNode(2)),
                        new ListNode(2, new ListNode(1))),
                // Input: head = [] -> []
                Arguments.of(new ListNode(), new ListNode()),
                // Input: head = null -> null
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsIsHappy(ListNode head, ListNode expected) {
        // given
        ReverseLinkedList solution = new ReverseLinkedList();

        // when
        ListNode result = solution.reverseList(head);

        // then
        while (result != null) {
            Assertions.assertThat(result.val).isEqualTo(expected.val);
            result = result.next;
            expected = expected.next;
        }
    }
}