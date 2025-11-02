class Solution {
    public void markGuarded(int[][] prison,int row,int col,int m,int n)
    {
        int dupRow=row; int dupCol=col;
        //Check all ahead columns until you find a wall or guard
        col++;
        while(col>=0 && col<n && prison[row][col]!=1 && prison[row][col]!=-1)
        {
            prison[row][col]=2;
            col++;
        }
        //Check all behind columns until you find a wall or guard
        col=dupCol-1;
        while(col>=0&& col<n && prison[row][col]!=1 && prison[row][col]!=-1)
        {
            prison[row][col]=2;
            col--;
        }
        col=dupCol;
        //Check for row
        row++;
        while(row>=0 && row<m && prison[row][col]!=1 && prison[row][col]!=-1)
        {
            prison[row][col]=2;
            row++;
        }

        row=dupRow-1;
        while(row>=0 && row<m && prison[row][col]!=1 && prison[row][col]!=-1)
        {
            prison[row][col]=2;
            row--;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] prison=new int[m][n];
        for(int i=0;i<guards.length;i++)
        {
            prison[guards[i][0]][guards[i][1]]=1;
            
        }
        for(int i=0;i<walls.length;i++)
        {
           
            prison[walls[i][0]][walls[i][1]]=-1;
        }
        for(int i=0;i<guards.length;i++)
        {
            markGuarded(prison,guards[i][0],guards[i][1],m,n);
        }
        int count=0;
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                if (prison[i][j] == 0) {  
                    count++;
        }
    }
}
return count;
    }
}