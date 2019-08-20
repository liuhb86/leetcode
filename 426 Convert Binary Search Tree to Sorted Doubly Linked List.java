/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node node) {
        if (node == null) return null;
        Node head = treeToDoublyList(node.left);
        if (head != null) {
            Node last = head.left;
            last.right = node;
            node.left = last;
        } else {
            head = node;
        }
        Node right = treeToDoublyList(node.right);
        if (right != null) {
            node.right = right;
            Node last = right.left;
            right.left = node;
            last.right = head;
            head.left = last;
        } else {
            head.left = node;
            node.right = head;
        }
        return head;
    }
}