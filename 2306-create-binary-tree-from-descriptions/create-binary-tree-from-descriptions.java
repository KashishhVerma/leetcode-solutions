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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode>map=new HashMap<>();
        Set<Integer>set=new HashSet<>();
        for(int d[]:descriptions){
            int p=d[0];
            int c=d[1];
            int l=d[2];
            TreeNode par=map.computeIfAbsent(p,k->new TreeNode(p));
            TreeNode chil=map.computeIfAbsent(c,k->new TreeNode(c));
            if(l==1)par.left=chil;
            else par.right=chil;
            set.add(chil.val);
        }
        for(int d[]:descriptions){
            int pval=d[0];
            if(!set.contains(pval)) return map.get(pval);
        }
        return null;
    }
}