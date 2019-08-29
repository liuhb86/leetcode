/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        if (x == null) return null;
        if (x.right != null) {
            Node r = x.right;
            while (r.left != null) r = r.left;
            return r;
        }
        while (x.parent!=null && x.parent.right == x) x = x.parent;
        return x.parent;
    }
}