class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;          // number of full weeks
        int days = n % 7;           // leftover days
        int total = 0;
        
        // Sum for full weeks
        for (int i = 0; i < weeks; i++) {
            total += 28 + 7 * i;    // each week adds 28 + 7*i
        }
        
        // Sum for leftover days
        for (int i = 0; i < days; i++) {
            total += (weeks + 1) + i;
        }
        
        return total;
    }
}
