package pl.slemjet.katas.euclidean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonPrimeDivisorsTest {

    @Test
    void solutionTest() {
        assertEquals(1, CommonPrimeDivisors.solution(new int[]{15, 10, 2}, new int[]{75, 30, 5}));
    }
}
