class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int maxCount = 0;
        int left = 0;
        int k = 1;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                while(k == 0){
                    count -= nums[left];
                    if(nums[left] == 0){
                        k++;
                    }
                    left++;
                }
                k--;
            }
            else{
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        if(k == 1) return maxCount - 1;
        return maxCount;
    }
}