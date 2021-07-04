package us.slemjet.leetcode.medium.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.from_100_to_150.SortList.ListNode;

import java.util.stream.Stream;

class SortListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [4,2,1,3] -> [1,2,3,4]
                Arguments.of(
                        new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))),
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))),
                // [-1,5,3,4,0] -> [-1,0,3,4,5]
                Arguments.of(
                        new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))),
                        new ListNode(-1, new ListNode(0, new ListNode(3, new ListNode(4, new ListNode(5)))))),
                // [] -> []
                Arguments.of(
                        new ListNode(),
                        new ListNode())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSortList(ListNode head, ListNode expected) {
        // given
        SortList solution = new SortList();

        // when
        ListNode result = solution.sortList(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}