class Solution {
    int memo[][];
    public int minDifficulty(int[] jd, int d) {
        int n=jd.length;
        if(n<d) return -1;
        memo=new int[n][d+1];
        for(int row[]:memo){
            Arrays.fill(row,-1);
        }
        return solve(jd,n,0,d);
    }
    int solve(int[]jd,int n,int idx,int d){
        if(d==1){
            int maxDiff=0;
            for(int i=idx;i<n;i++){
                maxDiff=Math.max(maxDiff,jd[i]);
            }
            return maxDiff;
        }
        if(memo[idx][d]!=-1) return memo[idx][d];
        int currMax=0;
        int minTotal=Integer.MAX_VALUE;
        for(int i=idx;i<=n-d;i++){
            currMax=Math.max(currMax,jd[i]);
            int remain=solve(jd,n,i+1,d-1);
            minTotal=Math.min(minTotal,remain+currMax);
        }
        return memo[idx][d]=minTotal;
    }
}