package pl.slemjet.kata.tapeequilibrium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermMissingElemTest {

    @Test
    void missingElementTest() {
        assertEquals(4, PermMissingElem.solution(new int[]{2, 3, 1, 5}));
        assertEquals(5, PermMissingElem.solution(new int[]{2, 3, 1, 4}));
    }
}
