class Solution {
    public boolean isPowerOfTwo(int n) {
        // A number is a power of two if:
        // 1. It is positive.
        // 2. It has only one '1' in its binary representation.
        // This can be checked using the bitwise AND trick: n & (n - 1) == 0
        
        return n > 0 && (n & (n - 1)) == 0;
    }
}
