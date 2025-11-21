class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;

        // For each character 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            int left = -1, right = -1;

            // Find first and last occurrence
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == c) {
                    if (left == -1) left = i;
                    right = i;
                }
            }

            // If no room for a middle character, skip
            if (left != -1 && right != -1 && right - left > 1) {
                boolean[] seen = new boolean[26];

                // Count distinct characters between left and right
                for (int i = left + 1; i < right; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }

                // Add number of unique middle characters
                for (boolean b : seen) {
                    if (b) result++;
                }
            }
        }

        return result;
    }
}
