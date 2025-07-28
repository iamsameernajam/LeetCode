class Solution {
    int cnt = 0; // Removed static

    public int countMaxOrSubsets(int[] nums) {
        int maxBitwise = 0;
        for (int it : nums) {
            maxBitwise |= it;
        }

        generate(0, nums, 0, maxBitwise); // Avoid using List, just pass OR value
        return cnt;
    }

    void generate(int index, int[] nums, int currOr, int maxBitwise) {
        if (index == nums.length) {
            if (currOr == maxBitwise) cnt++;
            return;
        }

        // Include current element
        generate(index + 1, nums, currOr | nums[index], maxBitwise);

        // Exclude current element
        generate(index + 1, nums, currOr, maxBitwise);
    }
}