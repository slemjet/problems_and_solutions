package us.slemjet.leetcode.easy.from_150_to_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_150_to_200.IntersectionOfTwoLinkedLists.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class IntersectionOfTwoLinkedListsTest {

    private static Stream<Arguments> parameters() {
        ListNode common1 = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode common2 = new ListNode(2, new ListNode(4));
        return Stream.of(
                // Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3 -> Output: Intersected at '8'
                of(new ListNode(4, new ListNode(1, common1)),
                        new ListNode(5, new ListNode(6, new ListNode(1, common1))),
                        new ListNode(8)),
                // Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1 -> Output: Intersected at '2'
                of(new ListNode(1, new ListNode(9, new ListNode(1, common2))),
                        new ListNode(3, common2),
                        new ListNode(2)),
                // Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2 -> Output: No intersection
                of(new ListNode(2, new ListNode(6, new ListNode(4))),
                        new ListNode(1, new ListNode(5)),
                        null)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findMaxLength(ListNode headA, ListNode headB, ListNode expected) {
        // given
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        // when
        ListNode result = solution.getIntersectionNode(headA, headB);

        // then
        if (expected != null) {
            Assertions.assertThat(result).isNotNull();
            Assertions.assertThat(result.val).isEqualTo(expected.val);
        } else {
            Assertions.assertThat(result).isNull();
        }
    }
}