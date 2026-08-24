class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> map=new HashMap<>();
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            StringBuilder row=new StringBuilder();
            for(int j=0;j<n;j++){
                row.append(grid[i][j]+",");
            }
            String r =row.toString();
            map.put(r,map.getOrDefault(r,0)+1);
        }
        for(int i=0;i<m;i++){
            StringBuilder col=new StringBuilder();
            for(int j=0;j<n;j++){
                col.append(grid[j][i]+",");

            }
            String c=col.toString();
            if(map.containsKey(c)) count+=map.get(c);
        }
        return count;
    }

}