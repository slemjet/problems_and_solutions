package us.slemjet.leetcode.medium.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MyCalendarIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"MyCalendarTwo", "book", "book", "book", "book", "book", "book" },
                        new Integer[][]{null, new Integer[]{10, 20}, new Integer[]{50, 60}, new Integer[]{10, 40},
                                new Integer[]{5, 15}, new Integer[]{5, 10}, new Integer[]{25, 55}},
                        new Boolean[]{null, true, true, true, false, true, true})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMyCalendarITreeMap(String[] commands, Integer[][] params, Boolean[] expected) {
        MyCalendarII myCalendar2 = null;

        for (int i = 0; i < commands.length; i++) {
            if ("MyCalendarTwo".equals(commands[i]))
                myCalendar2 = new MyCalendarII();
            else if ("book".equals(commands[i]))
                Assertions.assertThat(myCalendar2.book(params[i][0], params[i][1])).isEqualTo(expected[i]);
        }
    }
}