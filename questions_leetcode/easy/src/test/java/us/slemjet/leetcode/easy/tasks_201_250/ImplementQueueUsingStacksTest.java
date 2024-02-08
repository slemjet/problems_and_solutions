package us.slemjet.leetcode.easy.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ImplementQueueUsingStacksTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"MyQueue", "push", "push", "peek", "pop", "empty"},
                        new Integer[]{null, 1, 2, null, null, null},
                        new Object[]{null, null, null, 1, 1, false})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testImplementQueueUsingStacksAmortized(String[] commands, Integer[] params, Object[] expected) {
        ImplementQueueUsingStacks.MyQueueAmortized myQueue = null;

        for (int i = 0; i < commands.length; i++) {
            if ("MyQueue".equals(commands[i]))
                myQueue = new ImplementQueueUsingStacks.MyQueueAmortized();
            else if ("push".equals(commands[i]))
                myQueue.push(params[i]);
            else if ("peek".equals(commands[i]))
                Assertions.assertThat(myQueue.peek()).isEqualTo(expected[i]);
            else if ("pop".equals(commands[i])) {
                Assertions.assertThat(myQueue.pop()).isEqualTo(expected[i]);
            } else if ("empty".equals(commands[i])) {
                Assertions.assertThat(myQueue.empty()).isEqualTo(expected[i]);
            }
        }
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testImplementQueueUsingStacksBasic(String[] commands, Integer[] params, Object[] expected) {
        ImplementQueueUsingStacks.MyQueueBasic myQueue = null;

        for (int i = 0; i < commands.length; i++) {
            if ("MyQueue".equals(commands[i]))
                myQueue = new ImplementQueueUsingStacks.MyQueueBasic();
            else if ("push".equals(commands[i]))
                myQueue.push(params[i]);
            else if ("peek".equals(commands[i]))
                Assertions.assertThat(myQueue.peek()).isEqualTo(expected[i]);
            else if ("pop".equals(commands[i])) {
                Assertions.assertThat(myQueue.pop()).isEqualTo(expected[i]);
            } else if ("empty".equals(commands[i])) {
                Assertions.assertThat(myQueue.empty()).isEqualTo(expected[i]);
            }
        }
    }
}