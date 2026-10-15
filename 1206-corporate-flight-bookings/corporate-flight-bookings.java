class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int res[]=new int[n];
        for(int b[]:bookings){
            int s=b[0]-1;
            int en=b[1];
            int seat=b[2];
            res[s]+=seat;
            if(en<n){
                res[en]-=seat;
            }

        }
        for(int i=1;i<n;i++){
            res[i]+=res[i-1];
        }
        return res;
    }
}