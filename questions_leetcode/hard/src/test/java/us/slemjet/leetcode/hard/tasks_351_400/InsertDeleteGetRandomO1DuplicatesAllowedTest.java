package us.slemjet.leetcode.hard.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class InsertDeleteGetRandomO1DuplicatesAllowedTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"},
                        new Integer[]{null, 1, 1, 2, null, 1, null},
                        new Object[]{null, true, false, true, List.of(1, 2), true, List.of(1, 2)}),
                Arguments.of(new String[]{"RandomizedCollection", "insert", "insert", "insert", "insert", "insert", "remove", "remove", "remove", "remove"},
                        new Integer[]{null, 4, 3, 4, 2, 4, 4, 3, 4, 4},
                        new Object[]{null, true, true, false, true, false, true, true, true, true}),
                Arguments.of(new String[]{"RandomizedCollection", "insert", "remove", "insert"},
                        new Integer[]{null, 1, 1, 1},
                        new Object[]{null, true, true, true})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRandomizedCollection(String[] commands, Integer[] params, Object[] expected) {
        InsertDeleteGetRandomO1DuplicatesAllowed.RandomizedCollection randomizedCollection = null;

        for (int i = 0; i < commands.length; i++) {
            if ("RandomizedCollection".equals(commands[i]))
                randomizedCollection = new InsertDeleteGetRandomO1DuplicatesAllowed.RandomizedCollection();
            else if ("insert".equals(commands[i]))
                Assertions.assertThat(randomizedCollection.insert(params[i])).isEqualTo(expected[i]);
            else if ("remove".equals(commands[i]))
                Assertions.assertThat(randomizedCollection.remove(params[i])).isEqualTo(expected[i]);
            else if ("getRandom".equals(commands[i])) {
                List<Integer> expected1 = (List<Integer>) expected[i];
                Assertions.assertThat(randomizedCollection.getRandom()).isIn(expected1);
            }
        }
    }
}