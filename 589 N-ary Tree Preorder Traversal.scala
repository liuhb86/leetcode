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
    public List<Integer> preorder(Node root) {
        List<Integer> r = new ArrayList<>();
        if (root==null) return r;
        Deque<Node> s = new ArrayDeque<>();
        s.addLast(root);
        while (!s.isEmpty()) {
            Node n = s.removeLast();
            r.add(n.val);
            for (int i=n.children.size()-1; i>=0; i-=1) {
                if(n.children.get(i) != null) s.addLast(n.children.get(i));
            }
        }
        return r;
    }
}