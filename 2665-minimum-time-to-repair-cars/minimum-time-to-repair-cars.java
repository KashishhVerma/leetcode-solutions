class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low=1;
        long minRank=ranks[0];
        for(int rank:ranks){
            minRank=Math.min(minRank,rank);
        }
        long high=minRank*(long)cars*cars;
        long ans=high;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(isPossible(ranks,mid,cars)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    boolean isPossible(int ranks[],long mid,int car){
        long req=0;
        for(int rank:ranks){
            req+=Math.sqrt(mid/rank);
            if(req>=car) return true;
        }
        return req>=car;
    }
}