class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, placed = 0;
        boolean[] used = new boolean[n];  // all baskets start empty

        for (int f : fruits) {            // pick each fruit
            for (int j = 0; j < n; j++) { // scan baskets from the left
                if (!used[j] && baskets[j] >= f) { // first free basket big enough
                    used[j] = true;       // mark basket as filled
                    placed++;             // one more fruit successfully placed
                    break;                // move to the next fruit
                }
            }
        }
        return n - placed;                // fruits still in your hands
    }
}
