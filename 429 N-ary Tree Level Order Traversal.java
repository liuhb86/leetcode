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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> r = new LinkedList<>();
        if (root == null) return r;
        List<Node> current = new LinkedList<>();
        current.add(root);
        while(current.size() > 0) {
            List<Integer> rc = new LinkedList<>();
            r.add(rc);
            List<Node> next = new LinkedList<>();
            for (Node n : current) {
                rc.add(n.val);
                for (Node t: n.children) {
                    next.add(t);
                }
            }
            current = next;
        }
        return r;
    }
}