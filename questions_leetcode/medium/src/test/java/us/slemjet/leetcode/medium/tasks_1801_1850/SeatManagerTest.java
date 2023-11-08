package us.slemjet.leetcode.medium.tasks_1801_1850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_201_250.DesignAddAndSearchWordsDataStructure;

import java.util.stream.Stream;

class SeatManagerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"},
                        new Integer[]{5, null, null, 2, null, null, null, null, 5},
                        new Integer[]{null, 1, 2, null, 2, 3, 4, 5, null})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordDictionary(String[] commands, Integer[] params, Integer[] expected) {
        SeatManager seatManager = null;

        for (int i = 0; i < commands.length; i++) {
            if ("SeatManager".equals(commands[i]))
                seatManager = new SeatManager(params[i]);
            else if ("reserve".equals(commands[i]))
                Assertions.assertThat(seatManager.reserve()).isEqualTo(expected[i]);
            else if ("unreserve".equals(commands[i]))
                seatManager.unreserve(params[i]);
        }
    }
}