package pl.slemjet.kata.cyclicrotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CyclicRotationTest {

    @Test
    void cycleArrayWithNewTest() {
        int[] array = new int[]{3, 8, 9, 7, 6};
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, CyclicRotation.solution(array, 3));

        int[] array2 = new int[]{3, 8, 9, 7, 6};
        assertArrayEquals(new int[]{6, 3, 8, 9, 7}, CyclicRotation.solution(array2, 1));

        int[] array3 = new int[]{0, 0, 0};
        assertArrayEquals(new int[]{0, 0, 0}, CyclicRotation.solution(array3, 1));

        int[] array4 = new int[]{3, 8, 9, 7, 6};
        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, CyclicRotation.solution(array4, 5));

        int[] array5 = new int[]{1, 2, 3, 4};
        assertArrayEquals(new int[]{3, 4, 1, 2}, CyclicRotation.solution(array5, 2));

        int[] array6 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(new int[]{6, 7, 8, 9, 1, 2, 3, 4, 5}, CyclicRotation.solution(array6, 4));

        assertArrayEquals(new int[]{1000},
                CyclicRotation.solution(new int[]{1000}, 5));

        assertArrayEquals(new int[]{1000},
                CyclicRotation.solution(new int[]{1, 1, 2, 3, 5}, 42));
    }

}
