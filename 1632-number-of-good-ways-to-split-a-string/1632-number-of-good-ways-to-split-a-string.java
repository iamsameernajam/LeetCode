class Solution {
    public int numSplits(String s) {
        // HashSet Approach
        // TC: O(n), SC: O(n)
        int n = s.length();
        int[] uniqueLeft = new int[n];
        int[] uniqueRight = new int[n];
        Set<Character> leftSet = new HashSet<>();
        Set<Character> rightSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            leftSet.add(s.charAt(i));
            uniqueLeft[i] = leftSet.size();
        }
        for (int i = 0; i < n; i++) {
            rightSet.add(s.charAt(n - 1 - i));
            uniqueRight[n - 1 - i] = rightSet.size();
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (uniqueLeft[i] == uniqueRight[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}