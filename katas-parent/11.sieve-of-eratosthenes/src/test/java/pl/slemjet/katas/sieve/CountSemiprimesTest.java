package pl.slemjet.katas.sieve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountSemiprimesTest {

    @Test
    void getNumberOfSemiPrimes() {
        assertArrayEquals(new int[]{10, 4, 0},
                CountSemiprimes.solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20}));
    }

    @Test
    void getNumberOfSemiPrimes1() {
        assertArrayEquals(new int[]{0},
                CountSemiprimes.solution(1, new int[]{1}, new int[]{1}));
    }
}
