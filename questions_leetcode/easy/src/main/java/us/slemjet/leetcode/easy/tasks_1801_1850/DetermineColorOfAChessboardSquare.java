package us.slemjet.leetcode.easy.tasks_1801_1850;

/**
 * 1812. Determine Color of a Chessboard Square
 */
public class DetermineColorOfAChessboardSquare {

    /**
     * Time: O(1)   ->  100.00%
     * Space:O(1)   ->  66.97%
     */
    public boolean squareIsWhite(String coordinates) {

        char[] chars = coordinates.toCharArray();
        int y = chars[0] - 'a';
        int x = chars[1] - '1';
        return y % 2 != x % 2; // If both odd -> black, else - white
    }
}
