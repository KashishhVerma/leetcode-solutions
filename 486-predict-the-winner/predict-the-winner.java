class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int memo[][]=new int[n][n];
        for(int row[]:memo) Arrays.fill(row,-1);
        return solve(memo,nums,0,n-1)>=0;
    }
    int solve(int memo[][],int nums[],int i,int j){
        if(i==j) return nums[i];
        if(memo[i][j]!=-1)return memo[i][j];
        int left=nums[i]-solve(memo,nums,i+1,j);
        int right=nums[j]-solve(memo,nums,i,j-1);
        return Math.max(left,right);
    }
}