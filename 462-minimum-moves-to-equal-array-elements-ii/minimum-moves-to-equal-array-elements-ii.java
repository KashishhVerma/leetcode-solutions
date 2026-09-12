class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int move=0;
        int left=0;
        int right=nums.length-1;
        while(left<right){
            move+=nums[right]-nums[left];
            left++;
            right--;
        }
        return move;

    }
}