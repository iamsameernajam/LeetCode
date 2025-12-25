class Solution {
    public int minStartValue(int[] nums) {
       
        for (int i = 1; i < nums.length; i++) {
            nums[i]= nums[i - 1]+nums[i]; 
        }
        int minAltitude = 0;
        for (int i=0;i<nums.length;i++) {
            minAltitude = Math.min(minAltitude,nums[i]);
        }
        if (minAltitude < 0) {
            return 1 - minAltitude; 
        } else {
            return 1;
        }
    }
}
