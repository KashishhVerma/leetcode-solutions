class Solution {
    public int maxRotateFunction(int[] nums) {
        long sum=0;
        long f0=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            f0+=nums[i]*i;
        }
        long max=f0;
        long prev=f0;
        for(int i=1;i<n;i++){
            long curr=prev+sum-n*nums[n-i];
            max=Math.max(max,curr);   
            prev=curr;  
        }
        return (int)max;
    }
}