class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        // Step 1: Find search space
        for (int w : weights) {
            left = Math.max(left, w);  // minimum capacity
            right += w;                // maximum capacity
        }

        // Step 2: Binary Search
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;       // try smaller capacity
            } else {
                left = mid + 1;    // need bigger capacity
            }
        }

        return left;   // minimum valid capacity
    }

    // Helper function
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int dayCount = 1;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                dayCount++;
                currentLoad = 0;
            }
            currentLoad += w;
        }

        return dayCount <= days;
    }
}
