package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import us.slemjet.leetcode.medium.arrays.TwoSum;

class TwoSumTest {

    @Test
    void twoSum() {
        // when
        var twoSum = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);

        // then
        Assertions.assertThat(twoSum).isEqualTo(new int[]{0, 1});

    }
}