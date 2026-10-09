class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        boolean vis[]=new boolean[n];
        int compo=0;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int con[]:connections){
            adj.get(con[0]).add(con[1]);
            adj.get(con[1]).add(con[0]);
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                compo++;
                dfs(adj,vis,i);
            }
        }
        return compo-1;
    }
    void dfs(List<List<Integer>> adj,boolean vis[],int node){
        vis[node]=true;
        for(int n:adj.get(node)){
            if(!vis[n]){
                vis[n]=true;
                dfs(adj,vis,n);
            }
        }
    }
}