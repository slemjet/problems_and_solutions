package us.slemjet.leetcode.zigzagconversion;

public class Solution {
    public String convert1(String s, int numRows) {

        if (numRows < 2) {
            return s;
        }

        String result = "";
        String[] letters = s.split("");

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        rows[0].append(letters[0]);
        int row = 1;
        boolean direction = true; // ascending
        for (int i = 1; i < letters.length; i++) {

            rows[row].append(letters[i]);

            // determine next row
            if (row == numRows - 1 || row == 0) {
                direction = !direction;
            }
            row = row + (direction ? 1 : -1);
        }

        for (int i = 0; i < rows.length; i++) {
            result += rows[i].toString();
        }

        return result;
    }
}
