/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer>result;
    public List<Integer> preorder(Node root) {
        result=new ArrayList<>();
        traverse(root,result);
        return result;
    }
    void traverse(Node root,List<Integer>result){
        if(root==null)return;
        result.add(root.val);
        for(Node child:root.children){
            traverse(child,result);
        }
    }

}