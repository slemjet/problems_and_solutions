package us.slemjet.leetcode.median_of_two_sorted_arr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void test() {
        // given
        Solution solution = new Solution();

        // when
        double medianSortedArrays1 = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        double medianSortedArrays2 = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        double medianSortedArrays3 = solution.findMedianSortedArrays(new int[]{}, new int[]{2, 3});

        // then
        Assertions.assertThat(medianSortedArrays1).isEqualTo(2.0d);
        Assertions.assertThat(medianSortedArrays2).isEqualTo(2.5d);
        Assertions.assertThat(medianSortedArrays3).isEqualTo(2.5d);
    }

    @Test
    void simpleTest() {
        double medianSortedArrays = new Solution().findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6});

        Assertions.assertThat(medianSortedArrays).isEqualTo(4.0);
    }
}