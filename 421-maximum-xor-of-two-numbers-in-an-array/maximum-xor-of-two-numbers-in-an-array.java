class Solution {
    class Node{
        Node[] child=new Node[2];
    }
    class Trie{
        Node root;
        Trie(){
            root=new Node();
        }
    
    void insert(int num){
        Node curr=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(curr.child[bit]==null){
                curr.child[bit]=new Node();
            }
            curr=curr.child[bit];
        }
    }
    int getMax(int num){
        Node curr=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            int opp=1-bit;
            if(curr.child[opp]!=null){
                max|=(1<<i);
                curr=curr.child[opp];
            }
            else{
                curr=curr.child[bit];
            }
        }
        return max;
    }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie=new Trie();
        for(int num:nums){
            trie.insert(num);
        }
        int max=0;
        for(int num:nums){
            max=Math.max(max,trie.getMax(num));
        }
        return max;
    }
}