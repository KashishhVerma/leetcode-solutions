class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String,Character>stc=new HashMap<>();
        HashMap<Character,String>cts=new HashMap<>();
        String[] str=s.split(" ");
        if(pattern.length()!=str.length)return false;
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String word=str[i];
            if(stc.containsKey(word)){
                if(stc.get(word)!=ch)return false;
            }
            else stc.put(word,ch);
            if(cts.containsKey(ch)){
                if(!cts.get(ch).equals(word)) return false;
            }
            else cts.put(ch,word);
        }
        return true;
    }
}