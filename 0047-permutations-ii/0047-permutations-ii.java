class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        // Use a set to automatically remove duplicate permutations
        Set<List<Integer>> ret = new HashSet<>();

        // Start with an empty permutation
        ret.add(new ArrayList<>());

        // Insert each number from nums into existing permutations
        for (int i : nums) {

            // Will store new permutations created in this iteration
            List<List<Integer>> nextPerm = new ArrayList<>();

            // For every existing permutation
            for (List<Integer> perm : ret) {

                // Try inserting the new number i at every possible position (0 ... size)
                for (int j = 0; j <= perm.size(); j++) {

                    // Create a new permutation based on the current one
                    List<Integer> copy = new ArrayList<>(perm);

                    // Insert number i at position j
                    copy.add(j, i);

                    // Add to next permutations list
                    nextPerm.add(copy);
                }
            }

            // Convert nextPerm to a set to remove duplicates
            ret = new HashSet<>(nextPerm);
        }

        // Convert set back to list before returning
        return new ArrayList<>(ret);
    }
}
