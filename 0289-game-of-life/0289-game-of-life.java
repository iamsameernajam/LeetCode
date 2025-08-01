class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public void gameOfLife(int[][] board) {
        int row=board.length;
        int col=board[0].length;

        int[][] temp=new int[row][col];

        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                temp[i][j]=board[i][j];
                q.offer(new pair(i,j));
            }
        }

        int[] dx={0,-1,-1,-1,0,1,1,1};
        int[] dy={1,1,0,-1,-1,-1,0,1};
        while(!q.isEmpty()){
            pair u=q.poll();
            int currX=u.x;
            int currY=u.y;
            int count1=0;
            
            for(int i=0;i<8;i++){
                int newX=currX+dx[i];
                int newY=currY+dy[i];

                if(newX<0 || newX>=row || newY<0 || newY>=col){
                    continue;
                }
                if(temp[newX][newY]==1){
                    count1++;
                }
            }
            if((count1<2 || count1>3) && temp[currX][currY]==1){
                board[currX][currY]=0;
            }
            if(count1==3 && temp[currX][currY]==0){
                board[currX][currY]=1;
            }
        }        
    }
}