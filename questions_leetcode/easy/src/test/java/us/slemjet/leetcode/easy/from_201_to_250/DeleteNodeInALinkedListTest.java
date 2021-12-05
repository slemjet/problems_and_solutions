package us.slemjet.leetcode.easy.from_201_to_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_201_to_250.DeleteNodeInALinkedList.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeInALinkedListTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [4,5,1,9] node = 5 -> Output: [4,1,9]
                Arguments.of(new ListNode(5, new ListNode(1, new ListNode( 9))),
                        new ListNode(1, new ListNode( 9)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLowestCommonAncestor(ListNode node, ListNode expected) {
        // given
        DeleteNodeInALinkedList solution = new DeleteNodeInALinkedList();

        // when
        solution.deleteNode(node);

        // then
        while (node != null){
            Assertions.assertThat(node.val).isEqualTo(expected.val);
            node = node.next;
            expected = expected.next;
        }
    }

}