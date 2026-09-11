/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        int max=0;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int minIdx=q.peek().idx;
            int last=0;
            int first=0;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                TreeNode node=curr.node;
                int currIdx=curr.idx-minIdx;
                if(i==0) first=currIdx;
                if(i==size-1) last=currIdx;
                if(node.left!=null) q.add(new Pair(node.left,2*currIdx+1));
                if(node.right!=null) q.add(new Pair(node.right,2*currIdx+2));
            }
            max=Math.max(max,last-first+1);
        }
        return max;
    }
}