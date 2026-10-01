class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> map=new HashMap<>();
        for(List<String> ticket:tickets){
            String u=ticket.get(0);
            String v=ticket.get(1);
            map.putIfAbsent(u,new PriorityQueue<>());
            map.get(u).add(v);
        }
        List<String> result=new ArrayList<>();
        dfs("JFK",map,result);
        Collections.reverse(result);
        return result;
    }
    void dfs(String airport,HashMap<String,PriorityQueue<String>> map,List<String> result){
        PriorityQueue<String> dest=map.get(airport);
        while(dest!=null  &&!dest.isEmpty()){
            String nextAir=dest.poll();
            dfs(nextAir,map,result);
        }
        result.add(airport);
    }

}