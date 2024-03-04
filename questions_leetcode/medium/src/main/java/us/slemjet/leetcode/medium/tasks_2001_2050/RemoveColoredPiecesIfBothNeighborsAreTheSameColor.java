package us.slemjet.leetcode.medium.tasks_2001_2050;


/**
 * 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 */
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

    /**
     * Time: O(n)   ->  92.93%
     * Space:O(1)   ->  70.54%
     */
    public boolean winnerOfGame(String colors) {

        char[] chars = colors.toCharArray();
        int aliceMoves = 0;
        int bobMoves = 0;

        for (int i = 1; i < colors.length() - 1; i++) { // Exclude edge chars
            if (chars[i - 1] == chars[i] && chars[i] == chars[i + 1]) {
                if (chars[i] == 'A') {
                    aliceMoves++;
                } else {
                    bobMoves++;
                }
            }
        }

        return aliceMoves > bobMoves;
    }

}
