class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prefixProduct=1;
        int suffixProduct=1;
        int result[]=new int[nums.length];
        for(int i=0;i<n;i++){
            result[i]=prefixProduct;
            prefixProduct*=nums[i];
        }
        for(int i=n-1;i>=0;i--){
            result[i]*=suffixProduct;
            suffixProduct*=nums[i];
        }
         return result;
    }
}