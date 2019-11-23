package pl.slemjet.katas.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinAbsSumTest {

    @Test
    void solutionTest() {
        assertEquals(0, MinAbsSum.solution(new int[]{1, 5 ,2, -2}));
    }

    @Test
    void solutionTest2() {
        assertEquals(7, MinAbsSum.solution(new int[]{7}));
    }

    @Test
    void solutionTest3() {
        assertEquals(0, MinAbsSum.solution(new int[]{3, 3, 3, 4, 5}));
    }
}
