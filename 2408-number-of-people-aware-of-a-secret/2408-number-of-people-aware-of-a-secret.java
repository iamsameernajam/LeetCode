class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long activeSharers = 0;
        final long MOD = (long) 1e9 + 7;
        
        for (int day = 2; day <= n; day++) {
            // Add people who become eligible to share today (started delay days ago)
            if (day - delay > 0) {
                activeSharers = (activeSharers + dp[day - delay]) % MOD;
            }
            // Remove people who forget today (started forget days ago)
            if (day - forget > 0) {
                activeSharers = (activeSharers - dp[day - forget] + MOD) % MOD;
            }
            // New people learning today equals current active sharers
            dp[day] = activeSharers;
        }
        
        // Sum people who learned in the last 'forget' days (those who still remember)
        long total = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            total = (total + dp[day]) % MOD;
        }
        
        return (int) total;
    }
}