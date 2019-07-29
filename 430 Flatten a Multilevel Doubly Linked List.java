/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Node r = new Node();
        Node last = r;
        Stack<Node> stack = new Stack();
        stack.push(head);
        while (!stack.empty()) {
            Node p = stack.pop();
            if (p != null) {
                //System.out.println(p.val);
                last.next = p;
                p.prev = last;
                last = p;
                stack.push(p.next);
                stack.push(p.child);
                p.child = null;
            }
        }
        Node result = r.next;
        if (result != null) result.prev = null;
        return result;
    }
}