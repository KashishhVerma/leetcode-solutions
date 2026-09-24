class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] set=new HashSet[26];
        int n=ideas.length;
        for(int i=0;i<26;i++){
            set[i]=new HashSet<>();

        }
        for(String idea:ideas){
            char first=idea.charAt(0);
            String sub=idea.substring(1);
            set[first-'a'].add(sub);
        }
        long ans=0;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                long common=0;
                for(String suffix:set[i]){
                    if(set[j].contains(suffix)) common++;
                }
                long distI=set[i].size()-common;
                long distJ=set[j].size()-common;
                ans+=2*distI*distJ;
            }
        }
        return ans;
    }
}