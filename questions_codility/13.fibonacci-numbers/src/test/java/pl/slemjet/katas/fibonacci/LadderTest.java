package pl.slemjet.katas.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void solutionTest() {
        assertArrayEquals(new int[]{5, 1, 8, 0, 1},
                Ladder.solution(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1}));
    }


    @Test
    void solutionTest1() {
        assertArrayEquals(new int[]{1},
                Ladder.solution(new int[]{1}, new int[]{1}));
    }

    @Test
    void solutionTestMax() {
        assertArrayEquals(new int[]{1, 2},
                Ladder.solution(new int[]{1, 50}, new int[]{1, 3}));
    }
}
