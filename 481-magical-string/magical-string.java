class Solution {
    public int magicalString(int n) {
        if(n<=0) return 0;
        if(n<=3) return 1;
        int nums[]=new int[n+1];
        nums[0]=1;
        nums[1]=2;
        nums[2]=2;
        int head=2;
        int tail=3;
        int num=1;
        int count=1;
        while(tail<n){
            int freq=nums[head];
            for(int i=0;i<freq && tail<n;i++){
                nums[tail]=num;
                if(num==1) {
                    count++;
                }
                tail++;
            }
            head++;
            num^=3;
        }
        return count;
    }
}