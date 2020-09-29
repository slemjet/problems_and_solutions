package us.slemjet.leetcode.medium.numbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    /**
     * Use backtracking
     * Runtime: 62.60%
     * Memory Usage: 99.78%
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        // Run backtrack with initial parameters
        backtrack(results, new ArrayList<>(), nums, 0);

        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> tempResults, int[] nums, int curr) {
        // Store previous result
        results.add(new ArrayList<>(tempResults));

        for (int i = curr; i < nums.length; i++) {
            tempResults.add(nums[i]);
            // proceed with current combination
            backtrack(results, tempResults, nums, i + 1);
            // remove latest element to give a try with next
            tempResults.remove(tempResults.size() - 1);
        }
    }

    /**
     * Use bit manipulation
     * Runtime: 100.00%
     * Memory Usage: 99.65%
     *
     * Number of subsets for {1 , 2 , 3 } = 2^3 . why ?
     * case    possible outcomes for the set of subsets
     *   1   ->          Take or dont take = 2
     *   2   ->          Take or dont take = 2
     *   3   ->          Take or dont take = 2
     *
     * therefore , total = 2*2*2 = 2^3 = { { } , {1} , {2} , {3} , {1,2} , {1,3} , {2,3} , {1,2,3} }
     *
     * Lets assign bits to each outcome  -> First bit to 1 , Second bit to 2 and third bit to 3
     * Take = 1
     * Dont take = 0
     *
     * 0) 0 0 0  -> Dont take 3 ,   Dont take 2 ,   Dont take 1 =   { }
     * 1) 0 0 1  -> Dont take 3 ,   Dont take 2 ,       take 1  =   { 1 }
     * 2) 0 1 0  -> Dont take 3 ,       take 2  ,   Dont take 1 =   { 2 }
     * 3) 0 1 1  -> Dont take 3 ,       take 2  ,       take 1  =   { 1 , 2 }
     * 4) 1 0 0  ->    take 3   ,   Dont take 2 ,   Dont take 1 =   { 3 }
     * 5) 1 0 1  ->    take 3   ,   Dont take 2 ,       take 1  =   { 1 , 3 }
     * 6) 1 1 0  ->    take 3   ,       take 2  ,   Dont take 1 =   { 2 , 3 }
     * 7) 1 1 1  ->    take 3   ,       take 2  ,       take 1  =   { 1 , 2 , 3 }
     *
     * In the above logic ,Insert S[i] only if (j>>i)&1 ==true   { j E { 0,1,2,3,4,5,6,7 }   i = ith element in the input array }
     *
     * element 1 is inserted only into those places where 1st bit of j is 1
     *    if( j >> 0 &1 )  ==> for above above eg. this is true for sl.no.( j )= 1 , 3 , 5 , 7
     *
     * element 2 is inserted only into those places where 2nd bit of j is 1
     *    if( j >> 1 &1 )  == for above above eg. this is true for sl.no.( j ) = 2 , 3 , 6 , 7
     *
     * element 3 is inserted only into those places where 3rd bit of j is 1
     *    if( j >> 2 & 1 )  == for above above eg. this is true for sl.no.( j ) = 4 , 5 , 6 , 7
     */
    public List<List<Integer>> subsetsBit(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0) return result;

        final int TOTAL_NUM = 1 << nums.length;
        for (int i = 0; i < TOTAL_NUM; i++) {
            List<Integer> tempResult = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    tempResult.add(nums[j]);
                }
            }
            result.add(tempResult);
        }

        return result;
    }
}
