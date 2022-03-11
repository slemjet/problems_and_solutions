package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_51_100.RotateList.ListNode;

import java.util.stream.Stream;

class RotateListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2,
                        new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(2, new ListNode(3)))))),
                Arguments.of(
                        new ListNode(0, new ListNode(1, new ListNode(2))), 4,
                        new ListNode(2, new ListNode(0, new ListNode(1))))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRotateRight(ListNode head, int k, ListNode expected) {
        // given
        RotateList solution = new RotateList();

        // when
        ListNode longestPalindrome = solution.rotateRight(head, k);

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo(expected);
    }
}