class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n=nums.length;
        List<String> res=new ArrayList<>();
        if(n==0) return res;
        for(int i=0;i<n;i++){
            int start=nums[i];
            while(i+1<n&& nums[i+1]==nums[i]+1)i++;
            int end=nums[i];
            if(start==end) res.add(String.valueOf(start));
            else res.add(start+"->"+end);
        }
        return res;
    }
}