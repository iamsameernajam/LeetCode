class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 1;

        int[][] rowSum = new int[n][m];
        int[][] colSum = new int[n][m];

        for (int i = 0; i < n; i++) {
            rowSum[i][0] = grid[i][0];
            for (int j = 1; j < m; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
            }
        }

        for (int j = 0; j < m; j++) {
            colSum[0][j] = grid[0][j];
            for (int i = 1; i < n; i++) {
                colSum[i][j] = colSum[i - 1][j] + grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int max = Math.min(n - i, m - j);
                if (ans > max) {
                    continue;
                }

                for (int k = 1; k < max; k++) {
                    int size = k + 1;
                    int target = rowSum[i][j + k] - (j > 0 ? rowSum[i][j - 1] : 0);
                    boolean isValid = true;

                    for (int r = i; r <= i + k && isValid; r++) {
                        int sum = rowSum[r][j + k] - (j > 0 ? rowSum[r][j - 1] : 0);
                        if (sum != target) {
                            isValid = false;
                            break;
                        }
                    }

                    if (!isValid) {
                        continue;
                    }

                    for (int c = j; c <= j + k && isValid; c++) {
                        int sum = colSum[i + k][c] - (i > 0 ? colSum[i - 1][c] : 0);
                        if (sum != target) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) {
                        continue;
                    }

                    int diag1 = 0;
                    for (int d = 0; d <= k; d++) {
                        diag1 += grid[i + d][j + d];
                    }
                    if (diag1 != target)
                        isValid = false;

                    int diag2 = 0;
                    for (int d = 0; d <= k; d++) {
                        diag2 += grid[i + d][j + k - d];
                    }
                    if (diag2 != target)
                        isValid = false;

                    if (isValid) {
                        ans = Math.max(ans, size);
                    }
                }
            }
        }
        return ans;
    }
}