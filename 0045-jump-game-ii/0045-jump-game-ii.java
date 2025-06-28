class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0, right = 0;

        while (right < nums.length - 1) {
            int max = 0;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, i + nums[i]);
            }
            left = right + 1;
            right = max;
            jumps++;
        }

        return jumps;
    }
}
