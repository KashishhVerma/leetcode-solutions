/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        dfs(sb,root);
        return sb.toString();
    }
    void dfs(StringBuilder sb,TreeNode root){
        if(root==null) return;
        sb.append(root.val).append(",");
        dfs(sb,root.left);
        dfs(sb,root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<Integer>q=new LinkedList<>();
        for(String s:data.split(",")){
            q.add(Integer.parseInt(s));
        }
        return build(q,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    TreeNode build(Queue<Integer>q,int lower,int upper){
        if(q.isEmpty()) return null;
        int curr=q.peek();
        if(curr<lower||curr>upper)return null;
        q.poll();
        TreeNode root=new TreeNode(curr);
       root.left= build(q,lower,curr);
        root.right=build(q,curr,upper);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;