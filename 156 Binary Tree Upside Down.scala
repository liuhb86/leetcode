/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def upsideDownBinaryTree(root: TreeNode): TreeNode = {
        if (root == null) return null;
        if (root.left == null) return root;
        val left = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root
        root.left = null;
        root.right = null;
        return left;
    }
}