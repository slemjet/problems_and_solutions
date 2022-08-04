package us.slemjet.leetcode.medium.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MyCalendarITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"MyCalendar", "book", "book", "book"},
                        new Integer[][]{null, new Integer[]{10, 20}, new Integer[]{15, 25}, new Integer[]{20, 30}},
                        new Boolean[]{null, true, false, true}),
                Arguments.of(new String[]{"MyCalendar", "book", "book", "book", "book", "book"},
                        new Integer[][]{null, new Integer[]{37, 50}, new Integer[]{33, 50}, new Integer[]{4, 17}, new Integer[]{35, 48}, new Integer[]{8, 25}},
                        new Boolean[]{null, true, false, true, false, false}),
                Arguments.of(new String[]{"MyCalendar", "book", "book", "book", "book", "book", "book", "book", "book", "book", "book"},
                        new Integer[][]{null,
                                new Integer[]{47, 50}, new Integer[]{33, 41}, new Integer[]{39, 45}, new Integer[]{33, 42}, new Integer[]{25, 32},
                                new Integer[]{26, 35}, new Integer[]{19, 25}, new Integer[]{3, 8}, new Integer[]{8, 13}, new Integer[]{18, 27}},
                        new Boolean[]{null, true, true, false, false, true, false, true, true, true, false})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMyCalendarI(String[] commands, Integer[][] params, Boolean[] expected) {
        MyCalendarI myCalendarI = null;

        for (int i = 0; i < commands.length; i++) {
            if ("MyCalendar".equals(commands[i]))
                myCalendarI = new MyCalendarI();
            else if ("book".equals(commands[i]))
                Assertions.assertThat(myCalendarI.book(params[i][0], params[i][1])).isEqualTo(expected[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMyCalendarITreeMap(String[] commands, Integer[][] params, Boolean[] expected) {
        MyCalendarITreeMap myCalendarI = null;

        for (int i = 0; i < commands.length; i++) {
            if ("MyCalendar".equals(commands[i]))
                myCalendarI = new MyCalendarITreeMap();
            else if ("book".equals(commands[i]))
                Assertions.assertThat(myCalendarI.book(params[i][0], params[i][1])).isEqualTo(expected[i]);
        }
    }
}