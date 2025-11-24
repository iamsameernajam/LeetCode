public class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];

        dp[0] = false; 
        dp[1] = false;

        for (int i = 2; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && dp[i - x] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
