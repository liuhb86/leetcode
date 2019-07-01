/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int d = 0;
        for (Node c: root.children) {
            int dc = maxDepth(c);
            if (dc > d) d = dc;
        }
        return d +1;
    }
}