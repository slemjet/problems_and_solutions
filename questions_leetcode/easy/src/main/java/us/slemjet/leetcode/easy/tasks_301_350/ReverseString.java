package us.slemjet.leetcode.easy.tasks_301_350;

/**
 * 344. Reverse String
 */
public class ReverseString {

    /**
     * Runtime: 94.57%
     * Memory Usage: 9.33%
     */
    public void reverseString(char[] s) {

        if (s == null) return;

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            s[left] = (char) (s[left] ^ s[right]);
            s[right] = (char) (s[left] ^ s[right]);
            s[left] = (char) (s[left] ^ s[right]);
            left++;
            right--;
        }
    }

    /**
     * Runtime: 94.57%
     * Memory Usage: 73.69%
     */
    public void reverseStringTmp(char[] s) {
        if (s == null) return;

        int left = 0;
        int right = s.length - 1;
        char tmp;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
