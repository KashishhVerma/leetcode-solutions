class Solution {
    Map<String,Integer>map=new HashMap<>();
    List<List<String>> ans=new ArrayList<>();
    String bWord;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return ans;
        Queue<String> q=new LinkedList<>();
        bWord=beginWord;
        q.add(bWord);
        set.remove(bWord);
        map.put(bWord,0);
        while(!q.isEmpty()){
            String word=q.poll();
            int step=map.get(word);
            if(word.equals(endWord))break;
            char chars[]=word.toCharArray();
            for(int i=0;i<chars.length;i++){
                char org=chars[i];
                for(char ch='a';ch<='z';ch++){
                    chars[i]=ch;
                    String newWord=new String(chars);
                    if(set.contains(newWord)){
                        q.add(newWord);
                        map.put(newWord,step+1);
                        set.remove(newWord);
                    }

                }
                    chars[i]=org;
            }
        }
            if(map.containsKey(endWord)){
                List<String> path=new ArrayList<>();
                path.add(endWord);
                dfs(endWord,path);
            }
            return ans;
    }
        void dfs(String word,List<String>path){
            if(word.equals(bWord)){
                List<String>validPath=new ArrayList<>(path);
                Collections.reverse(validPath);
                ans.add(validPath);
                return;
            }
            int step=map.get(word);
            char chars[]=word.toCharArray();
            for(int i=0;i<chars.length;i++){
                char org=chars[i];
                for(char ch='a';ch<='z';ch++){
                    chars[i]=ch;
                    String prevWord=new String(chars);
                    if(map.containsKey(prevWord)&&map.get(prevWord)==step-1){
                        path.add(prevWord);
                        dfs(prevWord,path);
                        path.remove(path.size()-1);
                    }
                }
                chars[i]=org;
            }
        } 
}