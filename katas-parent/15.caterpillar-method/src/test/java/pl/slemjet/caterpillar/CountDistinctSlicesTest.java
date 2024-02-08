package pl.slemjet.caterpillar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDistinctSlicesTest {

    @Test
    public void testSolution(){
        assertEquals(9, CountDistinctSlices.solution(6, new int[]{3, 4, 5, 5, 2}));
    }

}
