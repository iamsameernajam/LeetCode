class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);  // O(n log n)
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        // If loop didn't return, the unique element is the last one
        return nums[nums.length - 1];
    }
}
