package us.slemjet.leetcode.easy.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MinStackTest {

    @Test
    void testMinStack() {
        // given
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // when
        int min1 = minStack.getMin();// return -3
        minStack.pop();
        int top = minStack.top();// return 0

        // then
        Assertions.assertThat(min1).isEqualTo(-3);
        Assertions.assertThat(top).isEqualTo(0);
    }
}