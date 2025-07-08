public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found valid combination
            return;
        }
        if (target < 0) return; // Invalid path, backtrack

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);                      // Choose
            backtrack(candidates, target - candidates[i], i, current, result); // Recurse
            current.remove(current.size() - 1);              // Unchoose (backtrack)
        }
    }
}
