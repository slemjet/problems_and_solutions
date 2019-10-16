package us.slemjet.leetcode.medium.arrays.zigzagconversion;

public class Solution {
    public String convert1(String s, int numRows) {

            if (numRows < 2 || s.length() < numRows)
                return s;

            StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = new StringBuilder();
            }

            int row = 0;
            boolean direction = false; // rows ascending
            String[] letters = s.split("");
            for (int i = 0; i < letters.length; i++) {

                rows[row].append(letters[i]);

                // determine next row
                if (row == numRows - 1 || row == 0) {
                    direction = !direction;
                }
                row = row + (direction ? 1 : -1);
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < rows.length; i++) {
                result.append(rows[i]);
            }

            return result.toString();
    }

    public String convert2(String s, int numRows) {

        if (numRows < 2 || s.length() < numRows)
            return s;

        StringBuilder result = new StringBuilder();
        String[] letters = s.split("");

        int cycle = 2 * numRows - 2;

        // we split regularity into 2 parts - regular columns and diagonals between
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column + row < letters.length; column += cycle) {
                // append regular cycled column
                result.append(letters[column + row]);
                if(row != 0 && row != numRows - 1 && column - row + cycle < letters.length){
                    // append letters between cycled column (relative to next cycle)
                    result.append(letters[column - row + cycle]);
                }
            }
        }
        return result.toString();
    }
}
