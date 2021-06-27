package pl.slemjet.katas.minperimeterrectangle;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeaksTest {

    @Test @Disabled
    void getMaxGroups() {
        assertEquals(3, Peaks.solution(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }

    @Test
    void getMaxGroupsV2() {
        assertEquals(3, Peaks.getMaxGroupsV2(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }
}
