/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def sumOfLeftLeaves(root: TreeNode): Int = {
        sum(root, false)
    }
    
    def sum(root: TreeNode, isLeft: Boolean) : Int = {
        if (root == null) return 0
        if (root.left == null && root.right == null) return if (isLeft) root.value else 0
        sum(root.left, true) + sum(root.right, false)
    }
}