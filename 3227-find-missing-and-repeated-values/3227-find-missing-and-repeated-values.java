class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        int[] freq = new int[total + 1]; // 1-based indexing
        int repeated = -1, missing = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                freq[val]++;
            }
        }

        for (int i = 1; i <= total; i++) {
            if (freq[i] == 0) {
                missing = i;
            } else if (freq[i] == 2) {
                repeated = i;
            }
        }

        return new int[]{repeated, missing};
    }
}
