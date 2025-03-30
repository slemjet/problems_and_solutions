package us.slemjet.leetcode.medium.tasks_501_550;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RandomPickWithWeightTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"Solution", "pickIndex"},
                        new int[][]{new int[]{1}},
                        new Object[]{null, 0}),
                Arguments.of(new String[]{"Solution", "pickIndex", "pickIndex", "pickIndex", "pickIndex", "pickIndex"},
                        new int[][]{new int[]{1, 3}, null, null, null, null, null},
                        new Object[]{null, 1, 1, 1, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] commands, int[][] params, Object[] expected) {
        RandomPickWithWeight.Solution solution = null;

        for (int i = 0; i < commands.length; i++) {
            if ("Solution".equals(commands[i]))
                solution = new RandomPickWithWeight.Solution(params[i]);
            else if ("pickIndex".equals(commands[i])) {
                int pickIndex = solution.pickIndex();
            }
        }
    }
}