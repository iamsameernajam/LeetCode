class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countWays(nums,0,0,target);
    }
    public static int countWays(int nums[],int index,int sum,int target){
        if(index==nums.length){
            return sum==target ? 1 :0;
        }
        int add=countWays(nums,index+1,sum+nums[index],target);
        int subtract=countWays(nums,index+1,sum-nums[index],target);
        return add+subtract;
    }
}