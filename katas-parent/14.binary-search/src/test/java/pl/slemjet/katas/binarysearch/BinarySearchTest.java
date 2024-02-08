package pl.slemjet.katas.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void solution() {
        assertEquals(6, MinMaxDivision.solution(3, 5, new int[]{2, 1, 5, 1, 2, 2, 2}));
    }

    @Test
    void solutionMin1() {
        assertEquals(4, MinMaxDivision.solution(2, 10, new int[]{4, 4}));
    }

}
