package pl.slemjet.caterpillar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTrianglesTest {

    @org.junit.jupiter.api.Test
    void solutionTest() {
        assertEquals(4, CountTriangles.solution(new int[]{10, 2, 5, 1, 8, 12}));
    }
}
