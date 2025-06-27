class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]memo=new int[m][n];
         for (int[] row : memo)
            Arrays.fill(row, -1);
        int maxLen=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    int len = findMax(matrix,i,j,memo);
                    maxLen=Math.max(len,maxLen);
                }
            }
        }
        return maxLen * maxLen;
    }
    public static int findMax(char matrix[][],int i,int j,int memo[][]){
        if(i>=matrix.length || j>=matrix[0].length || matrix[i][j]=='0'){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int right=findMax(matrix,i,j+1,memo);
        int down=findMax(matrix,i+1,j,memo);
        int diagonal=findMax(matrix,i+1,j+1,memo);
        memo[i][j]=1+Math.min(down,Math.min(right,diagonal));
        return memo[i][j];
    }
}