class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int t=road[2];
            list.get(u).add(new int[]{v,t});
            list.get(v).add(new int[]{u,t});
        }
        long dist[]=new long[n];
        long way[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        way[0]=1;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        int mod=1000000007;
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long curr[]=pq.poll();
            int u=(int)curr[0];
            long d=curr[1];
            if(d>dist[u]) continue;
            for(int nei[]:list.get(u)){
                int v=nei[0];
                int time=nei[1];
                if(dist[u]+time<dist[v]){
                    dist[v]=dist[u]+time;
                    way[v]=way[u];
                    pq.add(new long[]{v,dist[v]});
                }
                else if(dist[u]+time==dist[v]){
                    way[v]=(way[u]+way[v])%mod;
                }
            }
        }
        return (int)way[n-1];
    }
}