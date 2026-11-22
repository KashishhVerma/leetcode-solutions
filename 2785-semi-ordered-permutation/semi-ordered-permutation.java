class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int pos1=-1;
        int posn=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1)pos1=i;
            if(nums[i]==n)posn=i;
        }
        int swap=pos1+(n-1-posn);
        if(pos1>posn)swap--;
        return swap;

    }
}