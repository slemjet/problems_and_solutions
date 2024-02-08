package pl.slemjet.codility.prefixsums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDivTest {

    @Test
    void countDivisorsTest() {
        assertEquals(3, CountDiv.solution(6, 11, 2));
        assertEquals(6, CountDiv.solution(5, 16, 2));
    }
}
