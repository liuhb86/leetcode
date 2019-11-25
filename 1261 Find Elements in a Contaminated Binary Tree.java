/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {

    private TreeNode root = new TreeNode(-1);
    public FindElements(TreeNode root) {
        this.root.right = root;
    }
    
    public boolean find(int target) {
        TreeNode p = root;
        target = target + 1;
        int k = Integer.highestOneBit(target);
        while ( p != null && k > 0) {
            if ((target & k) > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
            target = target & (k-1);
            k = k >> 1;
        }
        return p != null;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */