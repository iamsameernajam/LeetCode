 
class Solution {
    public int count_pairs(int nums[],int low,int mid,int high){
        int right = mid+1;
        int count = 0;

        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i] > (long)2*nums[right])
              right++;
            count += right - (mid+1);
        }
        return count;
    }

    public void merge(int nums[],int low,int mid,int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left<= mid && right<=high){
            if(nums[left]<=nums[right])
                temp.add(nums[left++]);
            else
                temp.add(nums[right++]);
        }
        
        while(left<=mid)
           temp.add(nums[left++]);
           
        while(right<=high)
           temp.add(nums[right++]);
           
        for(int i=low;i<=high;i++)
           nums[i] = temp.get(i-low);
        
    }

    public int merge_sort(int nums[],int low,int high){
        int count = 0;
        int mid = (low+high)/2;

        if(low>=high)
          return count;
        
        count += merge_sort(nums,low,mid);
        count += merge_sort(nums,mid+1,high);
        count += count_pairs(nums,low,mid,high);
        merge(nums,low,mid,high);

        return count;
    }

    public int reversePairs(int[] nums) {
        return merge_sort(nums,0,nums.length-1);
    }
}