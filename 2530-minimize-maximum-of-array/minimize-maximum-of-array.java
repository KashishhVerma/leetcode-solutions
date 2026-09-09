class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefix=0;
        long max=0;
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            long avg=(prefix+i)/(i+1);
            max=Math.max(max,avg);
        }
        return (int)max;
    }
}