package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_1_50.AddTwoNumbers.ListNode;

import java.util.stream.Stream;

class AddTwoNumbersTest {

    public static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new ListNode(2, new ListNode(4, new ListNode(3))),
                        new ListNode(5, new ListNode(6, new ListNode(4))),
                        new ListNode(7, new ListNode(0, new ListNode(8)))
                ),
                Arguments.of(
                        new ListNode(0), new ListNode(0), new ListNode(0)
                ),
                Arguments.of(
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))),
                        new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))))
                )
        );
    }

    @MethodSource("parameters")
    @ParameterizedTest
    public void testAddTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        // Given
        AddTwoNumbers solution = new AddTwoNumbers();

        // When
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
