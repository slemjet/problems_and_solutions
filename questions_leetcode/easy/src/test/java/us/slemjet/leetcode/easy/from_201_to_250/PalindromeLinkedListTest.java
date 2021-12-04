package us.slemjet.leetcode.easy.from_201_to_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_201_to_250.PalindromeLinkedList.ListNode;

import java.util.stream.Stream;

class PalindromeLinkedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [1,2,2,1] - true
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))), true),
                // [1,2,3,2,1] - true
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))), true),
                // [1,2] - false
                Arguments.of(new ListNode(1, new ListNode(2)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCalculate(ListNode head, boolean expected) {
        // given
        PalindromeLinkedList solution = new PalindromeLinkedList();

        // when
        boolean result = solution.isPalindrome(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}