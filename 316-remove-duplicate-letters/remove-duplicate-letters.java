class Solution {
    public String removeDuplicateLetters(String s) {
        int lastIdx[]=new int[26];
        for(int i=0;i<s.length();i++){
            lastIdx[s.charAt(i)-'a']=i;
        }
        boolean visit[]=new boolean[26];
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(visit[ch-'a']) continue;
            while(!stack.isEmpty()&&ch<stack.peek()&& lastIdx[stack.peek()-'a']>i){
                visit[stack.pop()-'a']=false;
            }
            stack.push(ch);
            visit[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}