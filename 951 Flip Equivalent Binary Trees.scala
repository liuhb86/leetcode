/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def flipEquiv(root1: TreeNode, root2: TreeNode): Boolean = {
        if (root1==null&& root2==null) return true
        if (root1 == null || root2 == null) return false
        if (root1.value != root2.value) return false
        if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) return true
        flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
    }
}