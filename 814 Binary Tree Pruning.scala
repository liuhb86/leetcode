/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def pruneTree(root: TreeNode): TreeNode = {
        if (root == null) return null
        root.left = pruneTree(root.left)
        root.right = pruneTree(root.right)
        if (root.value == 0 && root.left == null && root.right == null)
            null
        else
            root
    }
}