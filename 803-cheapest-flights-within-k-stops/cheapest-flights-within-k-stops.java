class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int price[]=new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src]=0;
        for(int i=0;i<=k;i++){
            int[] temp=price.clone();
            for(int flight[]:flights){
                int s=flight[0];
                int d=flight[1];
                int p=flight[2];
                if(price[s]!=Integer.MAX_VALUE){
                    temp[d]=Math.min(temp[d],p+price[s]);
                }
            }
            price=temp;
        }
        return price[dst]==Integer.MAX_VALUE?-1:price[dst];
    }
}