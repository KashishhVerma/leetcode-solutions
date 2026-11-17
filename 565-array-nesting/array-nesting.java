class Solution {
    public int arrayNesting(int[] nums) {
        int n=nums.length;
        boolean visit[]=new boolean[n];
        int max=0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                int start=nums[i];
                int curr=start;
                int currLen=0;
                do{
                    currLen++;
                    curr=nums[curr];
                    visit[curr]=true;
                }
                while(curr!=start);
                max=Math.max(max,currLen);                
            }
        }
        return max;
    }
}