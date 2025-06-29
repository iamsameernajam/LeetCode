class Solution {
    public int numSubseq(int[] nums, int target) {
        //since we have to count number of ways so we if we have k length then we can have choices of 2^k
        //first we need to know how many numbers belong to this group with <=target
        //and here nothing is said about indices thus we can sort it
        Arrays.sort(nums);
        int n=nums.length;

        int MOD= 1_000_000_007;
        //precomputing powers so that we don't have to compute at every iterations later
        int[] power = new int[n];
        power[0]=1;
        for(int i=1; i<n; i++){
            power[i]=(power[i-1]<<1)%MOD;
        }

        int count=0, left=0, right=n-1;
        while(left<=right){//used eqality as we can single element as a subsequence
            if(nums[left]+nums[right]<=target){
                count=(count+power[right-left])%MOD;
                left++;
            }else right--;
        }
        return count;
    }
}