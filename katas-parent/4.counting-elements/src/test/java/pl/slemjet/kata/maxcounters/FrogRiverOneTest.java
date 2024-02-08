package pl.slemjet.kata.maxcounters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrogRiverOneTest {

    @Test
    void solutionTest() {
        assertEquals(6, FrogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }

    @Test
    void whenToJump() {
        assertEquals(6, FrogRiverOne.whenToJump(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }
}
