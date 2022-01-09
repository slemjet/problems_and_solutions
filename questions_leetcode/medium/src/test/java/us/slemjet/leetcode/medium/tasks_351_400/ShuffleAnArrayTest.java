package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ShuffleAnArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"Solution", "shuffle", "reset", "shuffle"},
                        new int[][]{new int[]{1, 2, 3}, null, null, null},
                        new Object[]{null,
                                Arrays.asList(new int[]{3, 2, 1}, new int[]{1, 2, 3}, new int[]{3, 1, 2}, new int[]{2, 3, 1}, new int[]{2, 1, 3}, new int[]{1, 3, 2}),
                                new int[]{1, 2, 3},
                                Arrays.asList(new int[]{3, 2, 1}, new int[]{1, 2, 3}, new int[]{3, 1, 2}, new int[]{2, 3, 1}, new int[]{2, 1, 3}, new int[]{1, 3, 2})})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRandomizedCollection(String[] commands, int[][] params, Object[] expected) {
        ShuffleAnArray.Solution randomizedCollection = null;

        for (int i = 0; i < commands.length; i++) {
            if ("Solution".equals(commands[i]))
                randomizedCollection = new ShuffleAnArray.Solution(params[i]);
            else if ("shuffle".equals(commands[i])) {
                Assertions.assertThat((List<int[]>) expected[i]).contains(randomizedCollection.shuffle());
            } else if ("reset".equals(commands[i]))
                Assertions.assertThat(randomizedCollection.reset()).isEqualTo(expected[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRandomizedCollection2(String[] commands, int[][] params, Object[] expected) {
        ShuffleAnArray.Solution2 randomizedCollection = null;

        for (int i = 0; i < commands.length; i++) {
            if ("Solution".equals(commands[i]))
                randomizedCollection = new ShuffleAnArray.Solution2(params[i]);
            else if ("shuffle".equals(commands[i])) {
                Assertions.assertThat((List<int[]>) expected[i]).contains(randomizedCollection.shuffle());
            } else if ("reset".equals(commands[i]))
                Assertions.assertThat(randomizedCollection.reset()).isEqualTo(expected[i]);
        }
    }
}