package pl.slemjet.katas.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxNonoverlappingSegmentsTest {

    @Test
    void solutionTest() {
        assertEquals(3, MaxNonoverlappingSegments.solution(new int[]{1, 3, 7, 9, 9}, new int[]{5, 6, 8, 9, 10}));
    }

    @Test
    void solutionTestEmpty() {
        assertEquals(0, MaxNonoverlappingSegments.solution(new int[]{}, new int[]{}));
    }
}
