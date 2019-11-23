package pl.slemjet.kata.cyclicrotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OddOccurrencesInArrayTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void findUnpairedSimple() {
        int unpaired = 5;
        int[] testArray = new int[]{1, 7, 2, 9, 7, 9, unpaired, 1, 2};
        assertEquals(unpaired, OddOccurrencesInArray.findUnpaired(testArray));
    }
}
