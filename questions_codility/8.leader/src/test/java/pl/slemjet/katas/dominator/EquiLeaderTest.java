package pl.slemjet.katas.dominator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquiLeaderTest {

    @Test
    void getEquiLeaderNum() {
        assertEquals(2, EquiLeader.solution(new int[]{4, 3, 4, 4, 4, 2}));
    }

    @Test
    void getEquiLeaderNumOne() {
        assertEquals(0, EquiLeader.solution(new int[]{0}));
    }

    @Test
    void getEquiLeaderNumTwo() {
        assertEquals(1, EquiLeader.solution(new int[]{0, 0}));
    }

    @Test
    void getEquiLeaderNum2() {
        assertEquals(3, EquiLeader.solution(new int[]{4, 4, 2, 5, 3, 4, 4, 4}));
    }
}
