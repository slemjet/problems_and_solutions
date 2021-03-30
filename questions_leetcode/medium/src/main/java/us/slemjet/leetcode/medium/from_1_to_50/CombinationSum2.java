package us.slemjet.leetcode.medium.from_1_to_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    /**
     * Runtime: 100.00%
     * Memory Usage: 100.00%
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrackUnique(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrackUnique(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int index) {
        if (target < 0 || index > candidates.length)
            return;

        if (target == 0)
            result.add(new ArrayList<>(solution));

        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) continue; // get next candidate. must != current to skip duplicates
            if(target < candidates[i]) break; // pointless to continue - optimization

            solution.add(candidates[i]);
            backtrackUnique(result, solution, candidates, target - candidates[i], i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}
