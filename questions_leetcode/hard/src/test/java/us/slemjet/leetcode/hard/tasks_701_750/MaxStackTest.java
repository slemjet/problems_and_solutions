package us.slemjet.leetcode.hard.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxStackTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"},
                        new Integer[]{null, 5, 1, 5, null, null, null, null, null, null},
                        new Integer[]{null, null, null, null, 5, 5, 1, 5, 1, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMyCalendarI(String[] commands, Integer[] params, Integer[] expected) {

        MaxStack maxStack = null;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            final Object expectedVal = expected[i];

            if ("MaxStack".equals(command)) {
                maxStack = new MaxStack();
            } else {
                switch (command) {
                    case "push" -> maxStack.push(params[i]);
                    case "top" -> Assertions.assertThat(maxStack.top()).isEqualTo(expectedVal);
                    case "pop" -> Assertions.assertThat(maxStack.pop()).isEqualTo(expectedVal);
                    case "peekMax" -> Assertions.assertThat(maxStack.peekMax()).isEqualTo(expectedVal);
                    case "popMax" -> Assertions.assertThat(maxStack.popMax()).isEqualTo(expectedVal);
                    default -> throw new IllegalArgumentException("Unknown command: " + command);
                }
            }
        }
    }
}