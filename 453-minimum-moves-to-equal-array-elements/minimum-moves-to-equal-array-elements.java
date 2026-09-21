class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int min=nums[0];
        int sum=0;
        for(int num:nums){
            min=Math.min(min,num);
            sum+=num;
        }
        return sum-(n*min);
    }
}