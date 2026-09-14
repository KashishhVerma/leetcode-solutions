class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if(stones[1]!=1)return false;
        Map<Integer,Integer> stone=new HashMap<>();
        for(int i=0;i<n;i++){
            stone.put(stones[i],i);
        }
        Map<Integer,Set<Integer>>memo=new HashMap<>();
        return dfs(1,1,stones,stone,memo);
    }
    boolean dfs(int idx,int lastJump,int stones[],Map<Integer,Integer>stone,Map<Integer,Set<Integer>>memo){
        if(idx==stones.length-1)return true;
        if(memo.containsKey(idx)&& memo.get(idx).contains(lastJump)) return false;
        for(int nextJump=lastJump-1;nextJump<=lastJump+1;nextJump++){
            if(nextJump<=0) continue;
            int nextPos=stones[idx]+nextJump;
            if(stone.containsKey(nextPos)){
                int nextIdx=stone.get(nextPos);
                if(dfs(nextIdx,nextJump,stones,stone,memo)) return true;
            }
        }
        memo.computeIfAbsent(idx,key->new HashSet<>()).add(lastJump);
        return false;
    }
}