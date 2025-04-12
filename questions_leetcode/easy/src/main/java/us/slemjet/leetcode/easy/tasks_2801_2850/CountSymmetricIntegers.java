package us.slemjet.leetcode.easy.tasks_2801_2850;

/**
 * 2843. Count Symmetric Integers
 */
public class CountSymmetricIntegers {

    /**
     *  Time:   O(n)    ->  91.25%
     *  Space:  O(1)    ->  87.50%
     */
    public int countSymmetricIntegers(int low, int high) {

        int result = 0;

        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                result++;
            }
        }

        return result;
    }

    private boolean isSymmetric(int num) {
        int digitsCount = 0, temp = num;

        // Count digits
        while (temp > 0) {
            digitsCount++;
            temp /= 10;
        }

        // Skip numbers with odd digit count
        if ((digitsCount & 1) == 1) return false;

        int halfDigits = digitsCount / 2;
        int leftSum = 0, rightSum = 0;

        // First goes right sum (lower)
        for (int i = 0; i < halfDigits; i++) {
            rightSum += num % 10;
            num /= 10;
        }

        // Next come left sum (higher)
        for (int i = 0; i < halfDigits; i++) {
            leftSum += num % 10;
            num /= 10;
        }

        return leftSum == rightSum;
    }
}
