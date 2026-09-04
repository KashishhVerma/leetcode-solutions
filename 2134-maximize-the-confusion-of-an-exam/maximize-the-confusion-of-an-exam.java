class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMax(answerKey,k,'T'),getMax(answerKey,k,'F'));
    }
    int getMax(String str,int k,char target){
        int left=0;
        int max=0;
        int nonTarget=0;
        for(int right=0;right<str.length();right++){
            if(str.charAt(right)!=target){
                nonTarget++;
            }
            while(nonTarget>k){
                if(str.charAt(left)!=target){
                    nonTarget--;
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}