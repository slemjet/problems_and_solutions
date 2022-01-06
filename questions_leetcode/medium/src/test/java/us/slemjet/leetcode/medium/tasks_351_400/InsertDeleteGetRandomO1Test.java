package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class InsertDeleteGetRandomO1Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"},
                        new Integer[]{null, 1, 2, 2, null, 1, 2, null},
                        new Object[]{null, true, false, true, 2, true, false, 2}),
                Arguments.of(new String[]{"RandomizedSet", "insert", "insert", "remove", "insert", "remove", "getRandom"},
                        new Integer[]{null, 0, 1, 0, 2, 1, 1, null},
                        new Object[]{null, true, true, true, true, true, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRandomizedSet(String[] commands, Integer[] params, Object[] expected) {
        InsertDeleteGetRandomO1.RandomizedSet randomizedSet = null;

        for (int i = 0; i < commands.length; i++) {
            if ("RandomizedSet".equals(commands[i]))
                randomizedSet = new InsertDeleteGetRandomO1.RandomizedSet();
            else if ("insert".equals(commands[i]))
                Assertions.assertThat(randomizedSet.insert(params[i])).isEqualTo(expected[i]);
            else if ("remove".equals(commands[i]))
                Assertions.assertThat(randomizedSet.remove(params[i])).isEqualTo(expected[i]);
            else if ("getRandom".equals(commands[i]))
                Assertions.assertThat(randomizedSet.getRandom()).isEqualTo(expected[i]);
        }
    }
}