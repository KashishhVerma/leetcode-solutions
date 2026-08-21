class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(i,0,board);
             if(board[i][n-1]=='O') dfs(i,n-1,board);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O') dfs(0,j,board);
            if(board[m-1][j]=='O') dfs(m-1,j,board);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]='X';
                 if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }
    void dfs(int i,int j,char[][]board){
        int row=board.length;
        int col=board[0].length;
        if(i>=row||j>=col||i<0||j<0||board[i][j]!='O') return;
        board[i][j]='#';
        dfs(i+1,j,board);
        dfs(i,j+1,board);
        dfs(i-1,j,board);
        dfs(i,j-1,board);
    }
}