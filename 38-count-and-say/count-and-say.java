class Solution {
    public String countAndSay(int n) {
        if(n<=0) return "";
        String s="1";
        for(int i=1;i<n;i++){
            s=getNext(s);
        }
        return s;
    }
    public String getNext(String s){
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=0;i<s.length();i++){
            if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)) count++;
            else {sb.append(count).append(s.charAt(i)) ; count=1;}
        }
        return sb.toString();
    }
}