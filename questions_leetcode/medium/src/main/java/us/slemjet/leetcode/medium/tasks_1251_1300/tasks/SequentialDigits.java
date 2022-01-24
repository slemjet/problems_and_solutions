package us.slemjet.leetcode.medium.tasks_1251_1300.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. Sequential Digits
 */
public class SequentialDigits {

    /**
     *
     */
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();

        int value = 1;
        int add = 1;
        int cnt = 1;
        while (value < low / 10) {
            value = value * 10 + ++cnt;
            add = add * 10 + 1;
        }

        cnt = 1;
        while (value <= high) {
            if (low <= value) result.add(value);
            value += add;
            cnt++;
            if (cnt == 10) {
                add = add * 10 + 1;
                int tmp = value;
                cnt = 1;
                value = 1;
                while (tmp > 0){
                    value = value * 10 + ++cnt;
                    tmp /= 10;
                }
                cnt = 1;
            }
        }

        return result;
    }

    /**
     * Runtime: 40.98%
     * Memory Usage: 45.90%
     */
    public List<Integer> sequentialDigits2(int low, int high) {

        List<Integer> sequence = new ArrayList<>();

        int num = 1;
        int cnt = 1;
        while (num < low / 100) {
            num *= 10;
            cnt++;
        }
        for (int i = 1; i <= 10 - cnt; i++) {
            int value = 0;
            for (int j = 0; j < cnt; j++) {
                value = value * 10 + j + i;
            }
            sequence.add(value);
        }

        List<Integer> result = new ArrayList<>();

        while (!sequence.isEmpty() && high > sequence.get(0)) {
            // Rebuild sequence
            int size = sequence.size();
            for (int i = 1; i < size; i++) {
                int value = sequence.get(i - 1) * 10 + 10 - size + i;
                sequence.set(i - 1, value);
                if (value >= low && value <= high) result.add(value);
                if (value > high) return result;
            }
            sequence.remove(sequence.size() - 1);
        }

        return result;
    }
}
