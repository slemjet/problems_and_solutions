package us.slemjet.leetcode.medium.tasks_601_650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DesignCircularDequeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront",
                                "getRear", "isFull", "deleteLast", "insertFront", "getFront" },
                        new Integer[][]{new Integer[]{3}, new Integer[]{1}, new Integer[]{2}, new Integer[]{3}, new Integer[]{4},
                                new Integer[]{}, new Integer[]{}, new Integer[]{}, new Integer[]{4}, new Integer[]{}},
                        new Object[]{null, true, true, true, false, 2, true, true, true, 4}),
                Arguments.of(new String[]{"MyCircularDeque", "insertFront", "getRear", "insertFront", "getRear", "insertLast",
                                "getFront", "getRear", "getFront", "insertLast", "deleteLast", "getFront" },
                        new Integer[][]{new Integer[]{3}, new Integer[]{9}, new Integer[]{}, new Integer[]{9}, new Integer[]{},
                                new Integer[]{5}, new Integer[]{}, new Integer[]{}, new Integer[]{}, new Integer[]{8},
                                new Integer[]{}, new Integer[]{}},
                        new Object[]{null, true, 9, true, 9, true, 9, 5, 9, false, true, 9})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMyCalendarI(String[] commands, Integer[][] params, Object[] expected) {

        DesignCircularDeque circularDeque = null;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            final Object expectedVal = expected[i];

            if ("MyCircularDeque".equals(command)) {
                circularDeque = new DesignCircularDeque(params[i][0]);
            } else {
                switch (command) {
                    case "insertFront" -> Assertions.assertThat(circularDeque.insertFront(params[i][0])).isEqualTo(expectedVal);
                    case "insertLast" -> Assertions.assertThat(circularDeque.insertLast(params[i][0])).isEqualTo(expectedVal);
                    case "getRear" -> Assertions.assertThat(circularDeque.getRear()).isEqualTo(expectedVal);
                    case "isFull" -> Assertions.assertThat(circularDeque.isFull()).isEqualTo(expectedVal);
                    case "deleteLast" -> Assertions.assertThat(circularDeque.deleteLast()).isEqualTo(expectedVal);
                    case "getFront" -> Assertions.assertThat(circularDeque.getFront()).isEqualTo(expectedVal);
                    default -> throw new IllegalArgumentException("Unknown command: " + command);
                }
            }
        }
    }
}