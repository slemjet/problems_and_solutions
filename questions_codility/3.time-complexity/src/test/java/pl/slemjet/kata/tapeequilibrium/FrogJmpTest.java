package pl.slemjet.kata.tapeequilibrium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrogJmpTest {

    @Test
    void jumpsTest() {
        assertEquals(3, FrogJmp.jumps(10, 85, 30));
        assertEquals(3, FrogJmp.jumps(10, 85, 25));
    }
}
