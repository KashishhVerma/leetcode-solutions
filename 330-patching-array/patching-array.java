class Solution {
    public int minPatches(int[] nums, int n) {
        long miss=1;
        int patch=0;
        int i=0;
        while(miss<=n){
            if(i<nums.length && miss>=nums[i]){
                miss+=nums[i];
                i++;
            }
            else{
                patch++;
                miss*=2;
            }
        }
        return patch;
    }
}