package us.slemjet.leetcode.hard.from_251_to_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindMedianFromDataStreamTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
                // [[], [1], [2], [], [3], []]
                // -> [null, null, null, 1.5, null, 2.0]
                Arguments.of(new String[]{"MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"},
                        new Integer[]{null, 1, 2, null, 3, null},
                        new Double[]{null, null, null, 1.5, null, 2.0}),
                // ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
                // [[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
                // [null,null,-1.00000,null,-1.50000,null,-2.00000,null,-2.50000,null,-3.00000]
                Arguments.of(new String[]{"MedianFinder", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian"},
                        new Integer[]{null, -1, null, -2, null, -3, null, -4, null, -5, null},
                        new Double[]{null, null, -1.00000, null, -1.50000, null, -2.00000, null, -2.50000, null, -3.00000})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindDuplicate(String[] commands, Integer[] params, Double[] expected) {

        FindMedianFromDataStream.MedianFinder medianFinder = null;
        for (int i = 0; i < commands.length; i++) {
            if ("MedianFinder".equals(commands[i]))
                medianFinder = new FindMedianFromDataStream.MedianFinder();
            else if ("addNum".equals(commands[i]))
                medianFinder.addNum(params[i]);
            else if ("findMedian".equals(commands[i]))
                Assertions.assertThat(medianFinder.findMedian()).isEqualTo(expected[i]);

        }
    }
}