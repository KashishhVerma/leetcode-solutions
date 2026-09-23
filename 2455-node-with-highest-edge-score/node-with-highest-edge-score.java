class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length;
        long score[]=new long[n];
        long max=-1;
        int idx=0;
        for(int i=0;i<n;i++){
            int target=edges[i];
            score[target]+=i;
        }
        for(int i=0;i<n;i++){
            if(max<score[i]){
                idx=i;
                max=score[i];
            }
        }
        return (int)idx;
    }
}