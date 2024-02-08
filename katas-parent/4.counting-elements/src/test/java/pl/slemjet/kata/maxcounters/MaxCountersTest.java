package pl.slemjet.kata.maxcounters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxCountersTest {

    @Test
    void testSolution() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2},
                MaxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }

    @Test
    void executeMaxIntegersTest() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2},
                MaxCounters.executeMaxIntegers(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
}
