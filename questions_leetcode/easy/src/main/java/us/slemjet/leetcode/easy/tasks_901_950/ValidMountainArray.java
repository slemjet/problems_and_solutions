package us.slemjet.leetcode.easy.tasks_901_950;

/**
 * 941. Valid Mountain Array
 */
public class ValidMountainArray {

    /**
     * Two pointer - less steps
     *
     * Runtime: 56.28%
     * Memory Usage: 7.22%
     */
    public boolean validMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < arr.length - 1 && arr[left] < arr[left + 1]) left++;
        while (right > 0 && arr[right] < arr[right - 1]) right--;

        return left == right && left > 0 && right < arr.length - 1; // Must meet and must be moved

    }

    /**
     * One pointer - start from beginning
     * <p>
     * Runtime: 56.28%
     * Memory Usage: 13.36%
     */
    public boolean validMountainArray2(int[] arr) {

        if (arr.length < 3) return false;

        int idx = 1;

        while (idx < arr.length && arr[idx] > arr[idx - 1]) {
            idx++;
        }

        if (idx == 1 || idx == arr.length) return false; // no increasing part or no space fore decreasing

        while (idx < arr.length && arr[idx] < arr[idx - 1]) {
            idx++;
        }

        return idx == arr.length; // Must reach end after increasing - decreasing
    }
}
