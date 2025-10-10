class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE; // Tracks the maximum energy value found
        int n = energy.length;

        // Loop over each possible starting offset (0 to k-1)
        for (int i = 0; i < k; i++) {
            int sum = 0; // Running postfix sum for current sequence

            // Traverse from the end towards the beginning, stepping by k
            for (int j = n - 1; j - i >= 0; j -= k) {
                sum += energy[j - i];        // Add current energy
                max = Math.max(sum, max);    // Update maximum if needed
            }
        }

        return max; // Return the highest energy that can be achieved
    }
}