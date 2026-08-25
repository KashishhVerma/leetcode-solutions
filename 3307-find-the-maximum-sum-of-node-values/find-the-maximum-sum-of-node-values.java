class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total=0;
        long min=Long.MAX_VALUE;
        int count=0;
        for(int num:nums){
            int val=num^k;
            int gain=val-num;
            if(gain>0){
                total+=val;
                count++;
            }
            else{
                total+=num;
            }
            min=Math.min(min,Math.abs(gain));
        }
        if(count%2==0) return total;
        return total-min;


    }
}