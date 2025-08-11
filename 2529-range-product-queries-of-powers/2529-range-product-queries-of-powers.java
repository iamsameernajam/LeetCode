class Solution {
     static final int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
        // 1) collect exponents of set bits, ascending (LSB→MSB)
        List<Integer> exp = new ArrayList<>();
        for (int b = 0; b < 31; b++) if (((n >> b) & 1) == 1) exp.add(b);

        int k = exp.size();

        // 2) prefix sums of exponents
        int[] psum = new int[k + 1];
        for (int i = 0; i < k; i++) psum[i + 1] = psum[i] + exp.get(i);

        // 3) precompute pow2 up to max needed exponent
        int maxSum = psum[k];
        int[] pow2 = new int[maxSum + 1];
        pow2[0] = 1;
        for (int i = 1; i <= maxSum; i++) pow2[i] = (int)((pow2[i - 1] * 2L) % MOD);

        // 4) answer queries in O(1)
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int totalExp = psum[r + 1] - psum[l];
            ans[i] = pow2[totalExp];
        }
        return ans;
    }
}