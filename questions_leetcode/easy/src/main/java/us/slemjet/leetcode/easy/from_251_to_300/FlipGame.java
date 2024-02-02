package us.slemjet.leetcode.easy.from_251_to_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 293. Flip Game
 */
public class FlipGame {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  77.85%
     */
    public List<String> generatePossibleNextMoves(String currentState) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i < currentState.length(); i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i) == currentState.charAt(i - 1)) {
                char[] chars = currentState.toCharArray();
                chars[i] = '-';
                chars[i - 1] = '-';
                result.add(new String(chars));
            }
        }
        return result;
    }
}
