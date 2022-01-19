package us.slemjet.leetcode.easy.from_201_to_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_201_to_250.RemoveLinkedListElements.ListNode;

import java.util.stream.Stream;

class RemoveLinkedListElementsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))),
                        6,
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
                Arguments.of(null, 2, null),
                Arguments.of(new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7)))), 7, null),
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))),
                        2,
                        new ListNode(1, new ListNode(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveElements(ListNode head, int val, ListNode expected) {
        // given
        RemoveLinkedListElements solution = new RemoveLinkedListElements();

        // when
        ListNode result = solution.removeElements(head, val);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}