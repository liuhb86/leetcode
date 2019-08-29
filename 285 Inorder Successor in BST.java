/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode x = p.right;
            while (x.left != null) x = x.left;
            return x;
        }
        TreeNode r = null;
        TreeNode q = root;
        while (q!= null && q!= p) {
            if (q.val > p.val) {
                r = q;
                q = q.left;
            } else {
                q = q.right;
            }
        }
        return r;
    }
}