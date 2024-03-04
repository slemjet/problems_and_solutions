package us.slemjet.leetcode.easy.tasks_3051_3100.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.common.ListNode;

import java.util.stream.Stream;

class WinnerOfTheLinkedListGameTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(ListNode.of(2, 1), "Even"),
                Arguments.of(ListNode.of(2, 5, 4, 7, 20, 5), "Odd"),
                Arguments.of(ListNode.of(4, 5, 2, 1), "Tie")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(ListNode head, String expected) {
        // given
        WinnerOfTheLinkedListGame solution = new WinnerOfTheLinkedListGame();

        // when
        String result = solution.gameResult(head);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}