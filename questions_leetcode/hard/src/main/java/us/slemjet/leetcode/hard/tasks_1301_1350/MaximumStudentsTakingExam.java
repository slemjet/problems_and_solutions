package us.slemjet.leetcode.hard.tasks_1301_1350;

import java.util.ArrayList;
import java.util.List;

/**
 * 1349. Maximum Students Taking Exam
 */
public class MaximumStudentsTakingExam {

    /**
     * DP Bottom Up
     * <p>
     * Runtime: 71.83%
     * Memory Usage: 14.08%
     */
    public int maxStudents(char[][] seats) {
        return maxStudents(seats, 0, 0, new Integer[seats.length][1 << seats[0].length]);
    }

    private int maxStudents(char[][] seats, int level, int bitMask, Integer[][] memo) {
        if (level >= seats.length) return 0;
        if (memo[level][bitMask] != null) return memo[level][bitMask];

        List<Integer> bitMasks = new ArrayList<>();
        bitMasks.add(0);

        for (int i = 0; i < seats[level].length; i++) {
            if (seats[level][i] == '#') continue;
            if ((bitMask & (1 << i - 1)) == 0 && (bitMask & (1 << (i + 1))) == 0) {
                List<Integer> copy = new ArrayList<>(bitMasks);
                for (Integer bm : copy) {
                    if ((bm >> (i + 1) & 1) == 0 && (bm >> (i - 1) & 1) == 0) {
                        bm |= 1 << i;
                        bitMasks.add(bm);
                    }
                }
            }
        }

        memo[level][bitMask] = 0;
        for (Integer bm : bitMasks) {
            int bitCount = Integer.bitCount(bm);
            int subResults = maxStudents(seats, level + 1, bm, memo);
            memo[level][bitMask] = Math.max(memo[level][bitMask], bitCount + subResults);
        }

        return memo[level][bitMask];
    }

    /**
     * Runtime: 71.83%
     * Memory Usage: 12.68%
     */
    public int maxStudents2(char[][] seats) {
        return maxStudents2(seats, 0, 0, new Integer[seats.length][1 << seats[0].length]);
    }

    private int maxStudents2(char[][] seats, int level, int bitMask, Integer[][] memo) {
        if (level >= seats.length) return 0;
        if (memo[level][bitMask] != null) return memo[level][bitMask];

        // Collect all possible combinations of bitmasks
        List<Integer> bitMasks = new ArrayList<>();
        populateBitMasks(bitMasks, seats[level], 0, bitMask, 0);

        memo[level][bitMask] = 0;
        for (Integer bm : bitMasks) {
            int bitCount = Integer.bitCount(bm);
            int subResults = maxStudents2(seats, level + 1, bm, memo);
            memo[level][bitMask] = Math.max(memo[level][bitMask], bitCount + subResults);
        }

        return memo[level][bitMask];
    }

    private void populateBitMasks(List<Integer> bitMasks, char[] seatRow, int val, int bitMask, int i) {
        if (i == seatRow.length) {
            bitMasks.add(val);
            return;
        }
        if (seatRow[i] == '.' &&
                (bitMask & (1 << i - 1)) == 0 && (bitMask & (1 << (i + 1))) == 0 &&
                (val >> (i + 1) & 1) == 0 && (val >> (i - 1) & 1) == 0) {
            // Try a combination with adding a student
            populateBitMasks(bitMasks, seatRow, val | (1 << i), bitMask, i + 1);
        }
        populateBitMasks(bitMasks, seatRow, val, bitMask, i + 1);
    }
}
