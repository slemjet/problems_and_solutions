package pl.slemjet.katas.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NailingPlanksTest {

    @Test
    void solutionTest1() {
        assertEquals(4, NailingPlanks.solution(
                new int[]{1, 4, 5, 8},
                new int[]{4, 5, 9, 10},
                new int[]{4, 6, 7, 10, 2}));
    }

    @Test
    void solutionTest2() {
        assertEquals(1, NailingPlanks.solution(
                new int[]{1}, new int[]{2}, new int[]{2}));
    }

    @Test
    void solutionTest3() {
        assertEquals(-1, NailingPlanks.solution(
                new int[]{2}, new int[]{2}, new int[]{1}));
    }

    @Test
    void solutionTest4() {
        assertEquals(4, NailingPlanks.solution(
                new int[]{1, 4, 5, 8},
                new int[]{4, 5, 9, 10},
                new int[]{4, 6, 7, 10, 2, 6, 4, 4}));
    }

}
