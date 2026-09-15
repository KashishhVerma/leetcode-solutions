class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n=timeSeries.length;
        int total=duration;
        for(int i=0;i<n-1;i++){
            int gap=timeSeries[i+1]-timeSeries[i];
            total+=Math.min(gap,duration);
        }
        return total;
    
    }
}