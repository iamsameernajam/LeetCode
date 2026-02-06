class Solution {
    public int minRemoval(int[] nums, int k) {
        if(nums.length==1) return 0;
        Arrays.sort(nums);
        int i=0,j=0;
        int ans=1;
        int n=nums.length;
        long max=nums[0];
        long min=nums[0];
        while(i<=j&&j<n){
            max=nums[j];
            while(i<j&&min*k<max){
                i++;
                min=nums[i];
            }
            ans=Math.max(ans,j-i+1);
            j++;
           
        }
        return n-ans;
    }

}