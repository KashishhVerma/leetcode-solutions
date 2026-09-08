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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int currSum=0;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                currSum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            list.add(currSum);
        }
        q.add(root);
        root.val=0;
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                int sibSum=0;
                if(curr.left!=null) sibSum+=curr.left.val;   
                if(curr.right!=null) sibSum+=curr.right.val;
                int totalSum=(level+1<list.size()?list.get(level+1):0);
                if(curr.left!=null){
                    curr.left.val=totalSum-sibSum;
                    q.add(curr.left);
                    
                }   
                if(curr.right!=null){
                    curr.right.val=totalSum-sibSum;
                    q.add(curr.right);
                }   
            }
                level++;
        }
        return root;
    }
}