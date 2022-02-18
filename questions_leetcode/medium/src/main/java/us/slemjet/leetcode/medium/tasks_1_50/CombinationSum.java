package us.slemjet.leetcode.medium.tasks_1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 */
public class CombinationSum {

    /**
     * Runtime: 62.29%
     * Memory Usage: 33.88%
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList(), candidates, target, 0);
        return result;
    }

    /**
     * @param result     accumulator for solved combinations
     * @param solution   currently processed solution
     * @param candidates list of potential values
     * @param target     target sum
     * @param index      currently processed starting element
     */
    private void backtrack(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int index) {
        if (target < 0 || index > candidates.length)
            return; // wrong direction
        else if (target == 0)
            result.add(new ArrayList<>(solution)); // solution found - adding a copy
        else {
            for (int i = index; i < candidates.length; i++) {
                solution.add(candidates[i]); // add new candidate and check if it'll work out with it
                backtrack(result, solution, candidates, target - candidates[i], i);
                // If we've reached this point - ether solution is already added to result or failed and we have to try with different number
                solution.remove(solution.size() - 1);
            }
        }
    }
}
