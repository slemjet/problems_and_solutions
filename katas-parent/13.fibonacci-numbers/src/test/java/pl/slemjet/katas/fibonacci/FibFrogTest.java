package pl.slemjet.katas.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibFrogTest {

    @Test
    void solutionTest() {

        assertEquals(3, FibFrog.solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
    }

    @Test
    void solutionTestMore() {

        assertEquals(2, FibFrog.solution(new int[]{1, 0, 0, 0, 0}));
    }

    @Test
    void solutionTestEmpty() {

        assertEquals(1, FibFrog.solution(new int[]{}));
    }

    @Test
    void solutionTest0() {

        assertEquals(1, FibFrog.solution(new int[]{0}));
    }

    @Test
    void solutionTest1() {

        assertEquals(1, FibFrog.solution(new int[]{1}));
    }

    @Test
    void solutionTest11() {

        assertEquals(1, FibFrog.solution(new int[]{1, 1}));
    }
}
