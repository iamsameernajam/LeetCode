import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int h = g.length; 
        int m = s.length; 
        int r = 0; 

        Arrays.sort(g); // Sort the greed factors
        Arrays.sort(s); // Sort the cookie sizes

        // Loop through cookies and children
        for (int l = 0; l < m && r < h; l++) {
            if (g[r] <= s[l]) { // If the current cookie can satisfy the current child's greed
                r++; // Move to the next child
            }
        }

        return r; // Return the number of content children
    }
}
