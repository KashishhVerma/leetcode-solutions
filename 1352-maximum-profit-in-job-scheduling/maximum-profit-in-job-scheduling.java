class Solution {
    class Jobs{
        int start;
        int end;
        int profit;
        Jobs(int start,int end,int profit){
            this.start=start;
            this.end=end;
            this.profit=profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        Jobs jobs[]=new Jobs[n];
        for(int i=0;i<n;i++){
            jobs[i]=new Jobs(startTime[i],endTime[i],profit[i]);     
        }
        Arrays.sort(jobs,(a,b)->Integer.compare(a.end,b.end));
        int dp[]=new int[n];
        dp[0]=jobs[0].profit;
        for(int i=1;i<n;i++){
            int exclude=dp[i-1];
            int include=jobs[i].profit;
            int notOverlap=binary(jobs,i);
            if(notOverlap!=-1) include+=dp[notOverlap];
            dp[i]=Math.max(include,exclude);
        }
        return dp[n-1];
    }
    int binary(Jobs[]jobs,int idx){
        int low=0;
        int high=idx-1;
        int result=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(jobs[mid].end<=jobs[idx].start){
                result=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return result;
    }
}