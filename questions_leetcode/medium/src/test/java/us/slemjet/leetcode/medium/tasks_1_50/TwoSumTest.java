package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    void twoSum() {
        // when
        int[] twoSum = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);

        // then
        Assertions.assertThat(twoSum).isEqualTo(new int[]{0, 1});

    }
}
