package pl.slemjet.katas.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TieRopesTest {

    @Test
    void solutionTest() {
        assertEquals(3, TieRopes.solution(4, new int[]{1, 2, 3, 4, 1, 1, 3}));
    }
}
