class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int ans = 0;
        int leftSum = 0;
        for (int x : nums) {
            if (x != 0) {
                leftSum += x;
            } else {
                // At a zero‐position
                if (leftSum * 2 == total) {
                    ans += 2;
                } else if (Math.abs(leftSum * 2 - total) == 1) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
