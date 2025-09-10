class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Put all dictionary words into a HashSet for O(1) lookup
        Set<String> dict = new HashSet<>(wordDict);

        // dp[i] = true means s[0..i) can be segmented into dictionary words
        boolean[] dp = new boolean[s.length() + 1];

        // Base case: empty string is always "segmentable"
        dp[0] = true;

        // Iterate through all substring lengths
        for (int i = 1; i <= s.length(); i++) {
            // Try splitting at every possible j before i
            for (int j = 0; j < i; j++) {
                // Condition 1: dp[j] must be true → prefix [0..j) is valid
                // Condition 2: s[j..i) must be a dictionary word
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true; // mark that s[0..i) is valid
                    break; // no need to check more j move to i
                }
            }
        }
        return dp[s.length()];
    }
}