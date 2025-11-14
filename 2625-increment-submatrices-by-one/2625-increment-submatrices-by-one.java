// Just add 1 to the matrix following the operation
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = 0;
            }
        }
        // Iterating each query
        for(int[] query : queries){
            // Taking the submatrix's boundary
            int x1 = query[0]; 
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            // Adding 1 to the matrix following the operation
            for(int i = x1; i <= x2; i++){
                for(int j = y1 ; j <= y2; j++){
                    matrix[i][j] += 1;
                }
            }
        }
        // Return the final result
        return matrix;
    }
}