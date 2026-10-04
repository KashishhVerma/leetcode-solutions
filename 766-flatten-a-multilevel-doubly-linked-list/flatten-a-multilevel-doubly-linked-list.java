/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr=head;
        if(head==null) return null;
        Stack<Node> stack=new Stack<>();
        while(curr!=null){
            if(curr.child!=null){
                if(curr.next!=null){
                    stack.push(curr.next);
                }
                curr.next=curr.child;
                curr.next.prev=curr;
                curr.child=null;
            }
            if(curr.next==null && !stack.isEmpty()){
                Node news=stack.pop();
                curr.next=news;
                news.prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }
}