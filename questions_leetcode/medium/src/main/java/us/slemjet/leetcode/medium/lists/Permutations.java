package us.slemjet.leetcode.medium.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {

    /**
     * Solution using backtrace algorithm
     * Runtime: 1 ms, 96.16%
     * Memory Usage: 94.33%
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> solution, int[] nums) {
        if(solution.size() == nums.length){
            // solution found - add
            result.add(new ArrayList<>(solution));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(solution.contains(nums[i]))
                continue; // skip existing

            solution.add(nums[i]);
            // proceed with current combination
            backtrack(result, solution, nums);
            // remove latest element to give a try with next
            solution.remove(solution.size() - 1);
        }
    }

    /**
     * Runtime: 7.00%
     * Memory Usage: 89.36%
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteNewLists(int[] nums) {
        List<Integer> input = IntStream.of(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        solve(result, new ArrayList<>(), input);
        return result;
    }

    private void solve(List<List<Integer>> result, List<Integer> solution, List<Integer> input) {
        if (input.isEmpty()) {
            result.add(solution);
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            List<Integer> newSolution = new ArrayList<>(solution);
            newSolution.add(input.get(i));
            List<Integer> newInput = new ArrayList<>(input);
            newInput.remove(i);
            solve(result, newSolution, newInput);
        }
    }
}
