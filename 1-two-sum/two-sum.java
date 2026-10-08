class Solution {
    public int[] twoSum(int[] nums, int target) {
     HashMap<Integer,Integer> map=new HashMap<>();
     int i=0;
     for(int num:nums){
        int diff=target-num;
        if(map.containsKey(diff)) return new int[]{i,map.get(diff)};
        map.put(num,i++);
     }  
     return new int[]{}; 
    }
}