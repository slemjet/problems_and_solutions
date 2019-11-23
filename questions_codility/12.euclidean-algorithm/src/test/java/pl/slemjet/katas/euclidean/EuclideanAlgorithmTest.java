package pl.slemjet.katas.euclidean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanAlgorithmTest {

    @Test
    void solutionTest() {
        assertEquals(5, ChocolatesByNumbers.solution(10, 4));
    }

    @Test
    void solutionTestBig() {
        assertEquals(947853, ChocolatesByNumbers.solution(947853, 4453));
    }
}
