package us.slemjet.leetcode.hard.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AllOOneDataStructureTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"},
                        new String[]{null, "hello", "hello", null, null, "leet", null, null},
                        new String[]{null, null, null, "hello", "hello", null, "hello", "leet"})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMyCalendarI(String[] commands, String[] params, String[] expected) {

        AllOOneDataStructure allOOneDataStructure = null;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            final Object expectedVal = expected[i];

            if ("AllOne".equals(command)) {
                allOOneDataStructure = new AllOOneDataStructure();
            } else {
                switch (command) {
                    case "inc" -> allOOneDataStructure.inc(params[i]);
                    case "getMaxKey" -> Assertions.assertThat(allOOneDataStructure.getMaxKey()).isEqualTo(expectedVal);
                    case "getMinKey" -> Assertions.assertThat(allOOneDataStructure.getMinKey()).isEqualTo(expectedVal);
                    default -> throw new IllegalArgumentException("Unknown command: " + command);
                }
            }
        }
    }
}