package pl.slemjet.katas.minperimeterrectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlagsTest {

    @Test
    void getNumberOfPeaks() {
        assertEquals(3, Flags.solution(new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6 ,2}));
    }
}
