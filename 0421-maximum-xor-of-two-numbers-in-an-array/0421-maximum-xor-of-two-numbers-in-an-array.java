class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int candidate = max | (1 << i);
            for (int p : prefixes) {
                if (prefixes.contains(p ^ candidate)) {
                    max = candidate;
                    break;
                }
            }
        }
        return max;
    }
}
