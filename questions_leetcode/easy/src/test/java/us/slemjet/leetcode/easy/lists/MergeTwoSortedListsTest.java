package us.slemjet.leetcode.easy.lists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.lists.MergeTwoSortedLists.ListNode;

import java.util.stream.Stream;

class MergeTwoSortedListsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new ListNode(1) {{
                            this.next = new ListNode(2);
                            this.next.next = new ListNode(4);
                        }},
                        new ListNode(1) {{
                            this.next = new ListNode(3);
                            this.next.next = new ListNode(4);
                        }},
                        new ListNode(1) {{
                            this.next = new ListNode(1);
                            this.next.next = new ListNode(2);
                            this.next.next.next = new ListNode(3);
                            this.next.next.next.next = new ListNode(4);
                            this.next.next.next.next.next = new ListNode(4);
                        }}),
                Arguments.of(
                        new ListNode(1),
                        new ListNode(2),
                        new ListNode(1) {{
                            this.next = new ListNode(2);
                        }})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isValidTest(ListNode l1, ListNode l2, ListNode expected) {
        // given
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // when
        ListNode merged = solution.mergeTwoLists(l1, l2);

        // then
        ListNode node = merged;
        ListNode expectedNode = expected;

        while (expectedNode != null) {
            Assertions.assertThat(node.val).isEqualTo(expectedNode.val);
            node = node.next;
            expectedNode = expectedNode.next;
        }
    }

}