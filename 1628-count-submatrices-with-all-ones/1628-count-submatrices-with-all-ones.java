class Solution {
    public int numSubmat(int[][] mat) {
    int n  = mat.length;
    int m  = mat[0].length; 
    int count = 0;
    int[][] dp = new int[n][m];
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < m ; j++){
            if(mat[i][j]==1){
                dp[i][j] = (j==0) ? 1 : 1 + dp[i][j-1];
            }
    }
}
          for(int i = 0 ; i < n ; i++){
              for(int j = 0 ; j < m ;j++){

                int minWidth = Integer.MAX_VALUE;
                  for(int k = i ; k >=0 && minWidth > 0 ;k--){
                    minWidth = Math.min(minWidth,dp[k][j]);
                    count+= minWidth;             
                  }
              }
          }
          return count;
    }
}