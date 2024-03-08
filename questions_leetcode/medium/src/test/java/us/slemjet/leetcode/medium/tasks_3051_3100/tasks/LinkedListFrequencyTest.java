package us.slemjet.leetcode.medium.tasks_3051_3100.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class LinkedListFrequencyTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 1, 2, 1, 2, 3), ListNode.of(3, 2, 1)),
                Arguments.of(ListNode.of(1, 1, 2, 2, 2), ListNode.of(2, 3)),
                Arguments.of(ListNode.of(6, 5, 4, 3, 2, 1), ListNode.of(1, 1, 1, 1, 1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(ListNode head, ListNode expected) {
        // given
        LinkedListFrequency solution = new LinkedListFrequency();

        // when
        ListNode result = solution.frequenciesOfElements(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}