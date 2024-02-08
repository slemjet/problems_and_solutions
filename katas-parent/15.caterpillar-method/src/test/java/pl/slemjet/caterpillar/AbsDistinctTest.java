package pl.slemjet.caterpillar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbsDistinctTest {

    @Test
    void solutionTest() {
        assertEquals(5, AbsDistinct.solution(new int[]{-5, -3, -1, 0, 3, 6}));
    }

    @Test
    void solutionTestMin() {
        assertEquals(3, AbsDistinct.solution(new int[]{-2147483648, -1, 0, 1}));
    }
}
