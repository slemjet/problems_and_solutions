package us.slemjet.leetcode.medium.arrays.container_with_most_water;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        // given
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // when
        int maxArea = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});

        // then
        Assertions.assertThat(maxArea).isEqualTo(49);
    }

    @Test
    void maxArea2() {
        // given
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // when
        int maxArea = solution.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});

        // then
        Assertions.assertThat(maxArea).isEqualTo(49);
    }
}