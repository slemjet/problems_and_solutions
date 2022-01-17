package us.slemjet.leetcode.hard.from_1_to_50;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] B = nums1.length > nums2.length ? nums1 : nums2;
        int[] A = B == nums1 ? nums2 : nums1;
        int m = A.length;
        int n = B.length;

        // following conditions need to be satisfied:
        // 1. j = (m + n + 1) / 2
        // 2. n >= m
        // 3. B[j - 1] <= A[i] && A[i] <= B[j]
        int iMin = 0, iMax = m, half = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = half - i;

            if (i < iMax && B[j - 1] > A[i]) {
                // i is too small => need to increase
                iMin = i + 1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                // i is too big => need to decrease
                iMax = i - 1;
            } else {
                // i is found
                double maxLeft;
                // handle border cases
                if (i == 0)
                    maxLeft = B[j - 1];
                else if (j == 0)
                    maxLeft = A[i - 1];
                else // handle standard case
                    maxLeft = Math.max(A[i - 1], B[j - 1]);

                boolean isEven = (B.length + A.length) % 2 == 1;
                if (isEven)
                    return maxLeft;
                else {
                    double minRight;
                    // handle border cases
                    if (i == m)
                        minRight = B[j];
                    else if (j == n)
                        minRight = A[i];
                    else // handle standard case
                        minRight = Math.min(A[i], B[j]);
                    return (maxLeft + minRight) / 2;
                }
            }
        }
        return 0;
    }
}
