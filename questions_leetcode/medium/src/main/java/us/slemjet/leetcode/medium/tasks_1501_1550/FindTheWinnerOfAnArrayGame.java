package us.slemjet.leetcode.medium.tasks_1501_1550;

/**
 * 1535. Find the Winner of an Array Game
 */
public class FindTheWinnerOfAnArrayGame {

    /**
     * Count for how many steps element is max
     *
     * Time: O(m) m = (k...n) -> 100.00%
     * Space: O(1) -> 74.64%
     */
    public int getWinner(int[] arr, int k) {

        int result = arr[0];
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            if(result < curr){
                result = curr;
                count = 1;
            }else {
                count++;
            }
            if(count == k){
                return result;
            }
        }

        return result;
    }
}
