package us.slemjet.leetcode.add_two_numbers;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void addTwoNumbers() {
        // given
        ListNode operand1 = new ListNode(2);
        operand1.next = new ListNode(4);
        operand1.next.next = new ListNode(3);

        ListNode operand2 = new ListNode(5);
        operand2.next = new ListNode(6);
        operand2.next.next = new ListNode(4);

        // when
        ListNode result = new Solution().addTwoNumbers(operand1, operand2);
        System.out.println(operand1);
        System.out.println(operand2);
        System.out.println(result);

        // then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.val).isEqualTo(7);
        Assertions.assertThat(result.next).isNotNull();
        Assertions.assertThat(result.next.val).isEqualTo(0);
        Assertions.assertThat(result.next.next).isNotNull();
        Assertions.assertThat(result.next.next.val).isEqualTo(8);

    }
}