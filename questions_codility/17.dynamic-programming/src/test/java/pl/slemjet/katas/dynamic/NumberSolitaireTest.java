package pl.slemjet.katas.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberSolitaireTest {

    @Test
    void solutionTest() {
        assertEquals(8, NumberSolitaire.solution(new int[]{1, -2, 0, 9, -1, -2}));
    }
}
