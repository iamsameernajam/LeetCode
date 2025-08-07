import java.util.*;

public class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Step 1: sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found valid combination
            return;
        }
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            // Step 2: skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            current.add(candidates[i]);
            // Step 3: move to next index, not reuse the same
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
