class Solution {
    int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        int maxLen=0;
         m=matrix.length;
         n=matrix[0].length;
        if(matrix==null||m==0)return -1;
        int memo[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int currLen=dfs(i,j,matrix,memo);
                maxLen=Math.max(currLen,maxLen);
            }
        }
        return maxLen;
    }
    int dfs(int r,int c,int matrix[][],int memo[][]){
        if(memo[r][c]!=0) return memo[r][c];
        int maxLen=1;
        for(int dir[]:dir){
            int nr=dir[0]+r;
            int nc=dir[1]+c;
            if(nr>=0 &&nr<m && nc>=0 && nc<n&& matrix[nr][nc]>matrix[r][c]){
               int len=1+dfs(nr,nc,matrix,memo);
                maxLen=Math.max(len,maxLen);
            }
        }
        return memo[r][c]=maxLen;
    }
}