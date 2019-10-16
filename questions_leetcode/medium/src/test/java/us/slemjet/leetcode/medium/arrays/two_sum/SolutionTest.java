package us.slemjet.leetcode.medium.arrays.two_sum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void twoSum() {
        // when
        var twoSum = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);

        // then
        Assertions.assertThat(twoSum).isEqualTo(new int[]{0, 1});

    }
}