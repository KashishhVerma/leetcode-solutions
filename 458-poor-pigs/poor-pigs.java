class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pig=0;
        int b=1;
        int round=minutesToTest/minutesToDie;
        int state=round+1;
        while(b<buckets){
            b*=state;
            pig++;
        }
        return pig;
    }
}