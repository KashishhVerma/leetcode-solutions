class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int total=0;
        int n=points.length;
        for(int i=0;i<n;i++){
            Map<Integer,Integer>map=new HashMap<>();
            for(int j=0;j<n;j++){
                if(i==j)continue;
                int x=points[i][0]-points[j][0];
                int y=points[i][1]-points[j][1];
                int dist=x*x+y*y;
                map.put(dist,map.getOrDefault(dist,0)+1);
            } 
            for(int val:map.values()){
                total+=val*(val-1);
            }

        }
        return total;
    }
}