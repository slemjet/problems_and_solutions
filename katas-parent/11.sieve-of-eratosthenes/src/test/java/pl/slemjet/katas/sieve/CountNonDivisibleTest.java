package pl.slemjet.katas.sieve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountNonDivisibleTest {

    @Test
    void countNumberOfDivisorsTest() {
        assertArrayEquals(new int[]{2, 4, 3, 2, 0},
                CountNonDivisible.solution(new int[]{3, 1, 2, 3, 6}));
    }
}
