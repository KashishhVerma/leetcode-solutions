class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer>curr=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        dfs(0,graph,curr,result);
        return result;
        
    }
    void dfs(int node,int[][]graph,List<Integer>curr,List<List<Integer>>result){
        curr.add(node);
        int target=graph.length-1;
        if(node==target){
            result.add(new ArrayList<>(curr));
        }
        else{
            for(int n:graph[node]){
                dfs(n,graph,curr,result);
            }
        }
        curr.remove(curr.size()-1);

    }
}