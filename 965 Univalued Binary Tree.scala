/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def isUnivalTree(root: TreeNode): Boolean = {
        //if (root == null) return true
        if (root.left != null && root.value != root.left.value) return false
        if (root.right != null && root.value != root.right.value) return false
        if (root.left != null && !isUnivalTree(root.left)) return false
        if (root.right != null && !isUnivalTree(root.right)) return false
        true
    }
}