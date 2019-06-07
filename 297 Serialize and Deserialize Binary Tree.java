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
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) return;
        sb.append('(');
        serialize(root.left, sb);
        sb.append(")(");
        serialize(root.right, sb);
        sb.append(')');
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new Buffer(data));
    }
    
    TreeNode deserialize(Buffer data) {
        if (!data.hasNext() || data.peek() == ')') return null;
        boolean neg = false;
        if (data.peek() =='-') {neg = true; data.next();}
        int n = 0;
        while (data.hasNext() && data.peek() >='0' && data.peek() <='9') {
            n = n*10 + (data.next() - '0');
        }
        if (neg) n = -n;
        TreeNode node = new TreeNode(n);
        if (data.hasNext() && data.peek() =='(') {
            data.next();
            node.left = deserialize(data);
            data.next(); data.next();
            node.right = deserialize(data);
            data.next();
        }
        return node;
    }
}

class Buffer{
    String data;
    int index = 0;
    public Buffer(String data) {
        this.data = data;
    }
    
    public boolean hasNext() {
        return index < data.length();
    }
    
    public char peek() {
        return data.charAt(index);
    }
    
    public char next() {
        char c = data.charAt(index);
        index += 1;
        return c;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));