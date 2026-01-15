class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxHGap = getMaxGap(hBars);
        int maxVGap = getMaxGap(vBars);
        
        int side = Math.min(maxHGap, maxVGap);
        return side * side;
    }
    private int getMaxGap(int[] bars) {
        Arrays.sort(bars);
        
        int maxConsecutive = 1;
        int current = 1;
        
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                current++;
            } else {
                current = 1;
            }
            maxConsecutive = Math.max(maxConsecutive, current);
        }
        
        // gap size = consecutive bars removed + 1
        return maxConsecutive + 1;
    }
}