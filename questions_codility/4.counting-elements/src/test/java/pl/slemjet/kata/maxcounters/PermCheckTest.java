package pl.slemjet.kata.maxcounters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermCheckTest {

    @Test
    void isPermutation() {
        assertEquals(1, PermCheck.isPermutation(new int[]{4, 1, 3, 2}));
        assertEquals(0, PermCheck.isPermutation(new int[]{4, 1, 3}));
    }
}
