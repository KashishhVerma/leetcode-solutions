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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        dfs(root,targetSum,curr,result);
        return result;
    }
    void dfs(TreeNode root,int target,List<Integer> curr,List<List<Integer>> result){
        if(root==null) return ;
        curr.add(root.val);
        if(root.left==null&& root.right==null&& target==root.val){
            result.add(new ArrayList<>(curr));
        }
        else{
            dfs(root.left,target-root.val,curr,result);
            dfs(root.right,target-root.val,curr,result);
        }
        curr.remove(curr.size()-1);
    }
}