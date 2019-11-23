package pl.slemjet.katas.minperimeterrectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountFactorsTest {

    @Test
    void getNumberOfFactors() {
        assertEquals(8, CountFactors.solution(24));
    }

    @Test
    void getNumberOfFactors1() {
        assertEquals(1, CountFactors.solution(1));
    }

    @Test
    void getNumberOfFactors4() {
        assertEquals(3, CountFactors.solution(4));
    }

    @Test
    void getNumberOfFactorsMax() {
        assertEquals(2, CountFactors.solution(Integer.MAX_VALUE));
    }
}
