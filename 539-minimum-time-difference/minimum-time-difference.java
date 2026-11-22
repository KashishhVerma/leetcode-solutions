class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min=Integer.MAX_VALUE;
        int n=timePoints.size();
        int mins[]=new int[n];
        for(int i=0;i<n;i++){
            String time=timePoints.get(i);
            int hr=Integer.parseInt(time.substring(0,2));
            int m=Integer.parseInt(time.substring(3,5));
            mins[i]=hr*60+m;
        }
        Arrays.sort(mins);
        for(int i=1;i<n;i++){
            min=Math.min(min,mins[i]-mins[i-1]);
            if(min==0)return 0;
        }
        int cycle=1440-mins[n-1]+mins[0];
        min=Math.min(min,cycle);
        return min;

    }
}