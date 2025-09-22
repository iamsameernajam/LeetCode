class Solution {
    public int superEggDrop(int k, int n) {
        // dp[m][eggs] = number of floors that can be tested
        // with m moves and "eggs" eggs
        // We only need a 1D array over eggs, updating for increasing m
        int[] dp = new int[k + 1];
        int m = 0;
        while (dp[k] < n) {
            m++;
            // update in reverse order to avoid overwriting
            for (int eggs = k; eggs >= 1; eggs--) {
                dp[eggs] = dp[eggs] + dp[eggs - 1] + 1;
            }
        }
        return m;
    }
}
