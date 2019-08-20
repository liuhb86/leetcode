/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal, null);
        if (head == null) {
            n.next = n;
            return n;
        }
        if (head.val == insertVal || head.next == head) {
            Node t = head.next;
            head.next = n;
            n.next = t;
            return head;
        }
        Node p = head;
        if (head.val > insertVal) {
            while(p.next.val >=p.val && p.next != head) {
                p = p.next;
            }
            if(insertVal <= p.next.val) {
                Node t = p.next;
                p.next = n;
                n.next = t;
                return head;
            }
            p = p.next;
        }
        while (p.next.val < insertVal && p.next.val >= p.val && p.next != head) {
            p = p.next;
        }
        Node t = p.next;
        p.next = n;
        n.next = t;
        return head;
    }
}