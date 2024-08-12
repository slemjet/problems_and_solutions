package us.slemjet.leetcode.easy.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KthLargestElementInAStreamTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"KthLargest", "add", "add", "add", "add", "add"},
                        new Object[]{new Object[]{3, new int[]{4, 5, 8, 2}}, 3, 5, 10, 9, 4},
                        new Integer[]{null, 4, 5, 5, 8, 8}),
                Arguments.of(new String[]{"KthLargest", "add", "add", "add", "add", "add"},
                        new Object[]{new Object[]{1, new int[]{}}, -3, -2, -4, 0, 4},
                        new Integer[]{null, -3, -2, -2, 0, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] commands, Object[] params, Integer[] expected) {
        KthLargestElementInAStream.KthLargest kthLargest = null;

        for (int i = 0; i < commands.length; i++) {
            if ("KthLargest".equals(commands[i])) {
                int k = (Integer) ((Object[]) params[i])[0];
                int[] nums = (int[]) ((Object[]) params[i])[1];
                kthLargest = new KthLargestElementInAStream.KthLargest(k, nums);
            } else if ("add".equals(commands[i])) {
                int var = (int) params[i];
                int expectedK = expected[i];
                Assertions.assertThat(kthLargest.add(var)).isEqualTo(expectedK);
            }
        }
    }
}