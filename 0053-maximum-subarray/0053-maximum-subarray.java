public class Solution {

    public static int maxSubArray(int[] arr) {
        int max_current = arr[0]; 
        int max_global = arr[0];   
        
        for (int i = 1; i < arr.length; i++) {
            max_current = Math.max(arr[i], max_current + arr[i]);
            if (max_current > max_global) {
                max_global = max_current;
            }
        }
        
        return max_global;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArray(arr);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
}
