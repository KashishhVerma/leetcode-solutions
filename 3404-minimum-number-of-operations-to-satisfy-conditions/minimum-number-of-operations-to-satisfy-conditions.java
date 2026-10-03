class Solution {
    public int minimumOperations(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int freq[][]=new int[n][10];
        for(int c=0;c<n;c++){
            for(int r=0;r<m;r++){
                int digit=grid[r][c];
                freq[c][digit]++;
            }
        }
        int dp[][]=new int[n][10];
        for(int v=0;v<10;v++){
            dp[0][v]=m-freq[0][v];
        }
        for(int c=1;c<n;c++){
            for(int v=0;v<10;v++){
                int currCol=m-freq[c][v];
                int minPrev=Integer.MAX_VALUE;
                for(int prev=0;prev<10;prev++){
                    if(prev!=v){
                        minPrev=Math.min(minPrev,dp[c-1][prev]);
                    }
                }
                dp[c][v]=currCol+minPrev;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int v=0;v<10;v++){
            min=Math.min(min,dp[n-1][v]);
        }
        return min;
    }
}