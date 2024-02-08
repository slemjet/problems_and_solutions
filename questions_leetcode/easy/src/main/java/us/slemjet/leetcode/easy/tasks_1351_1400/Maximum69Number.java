package us.slemjet.leetcode.easy.tasks_1351_1400;

import java.util.ArrayList;
import java.util.List;

/**
 * 1323. Maximum 69 Number
 */
public class Maximum69Number {

    /**
     * Runtime: 88.30%
     * Memory Usage: 96.92%
     */
    public int maximum69Number(int num) {

        List<Integer> values = new ArrayList<>();
        int dec = 10;
        while (num > 0) {
            values.add(num % dec);
            num /= 10;
        }

        for (int i = values.size() - 1; i >= 0; i--) {
            if (values.get(i) == 6) {
                values.set(i, 9);
                break;
            }
        }

        int result = 0;
        for (int i = values.size() - 1; i >= 0; i--) {
            result *= 10;
            result += values.get(i);
        }

        return result;
    }
}
