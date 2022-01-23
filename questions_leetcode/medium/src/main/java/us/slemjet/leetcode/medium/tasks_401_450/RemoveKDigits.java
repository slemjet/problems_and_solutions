package us.slemjet.leetcode.medium.tasks_401_450;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. Remove K Digits
 */
public class RemoveKDigits {

    /**
     * Runtime: 10 ms, faster than 48.52%
     * Memory Usage: 43.3 MB, less than 5.32%
     */
    public String removeKdigits(String num, int k) {

        char[] charArray = num.toCharArray();
        Deque<Character> chars = new ArrayDeque<>();

        chars.add(charArray[0]);

        int lastIdx = 1;

        while (lastIdx < charArray.length) {

            // check if next digit is smaller that prev - replace
            while (k > 0 && !chars.isEmpty() && chars.peekLast() > charArray[lastIdx]) {
                k--;
                chars.pollLast();
            }

            // enqueue new last element
            chars.addLast(charArray[lastIdx]);
            lastIdx++;
        }

        // clear remaining numbers (last are biggest)
        while (k > 0) {
            chars.pollLast();
            k--;
        }

        // skip leading 0
        while (!chars.isEmpty()) {
            if (chars.peekFirst() == '0')
                chars.pollFirst();
            else
                break;
        }

        StringBuilder res = new StringBuilder();

        while (!chars.isEmpty()) {
            res.append(chars.poll());
        }

        String result = res.toString();

        return result.isEmpty() ? "0" : result;
    }

}
