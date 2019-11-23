package pl.slemjet.caterpillar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinAbsSumOfTwoTest {

    @Test
    void solutionTest1() {
        assertEquals(1, MinAbsSumOfTwo.solution(new int[]{1, 4, -3}));
    }

    @Test
    void solutionTest2() {
        assertEquals(3, MinAbsSumOfTwo.solution(new int[]{-8, 4, 5, -10, 3}));
    }

    @Test
    void solutionTest0() {
        assertEquals(0, MinAbsSumOfTwo.solution(new int[]{0}));
    }
}
