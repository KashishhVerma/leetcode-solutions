class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int val=entry.getKey();
            int freq=entry.getValue();
            if(k==0){
                if(freq>=2) count++;
            }
            else {
                if(map.containsKey(val+k)) count++;
            }
        }
        return count;
    }
}