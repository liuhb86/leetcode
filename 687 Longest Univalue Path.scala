/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def longestUnivaluePath(root: TreeNode): Int = {
        if (root == null) return 0
        path(root, 0)._1 - 1
    }
    
    def path(node: TreeNode, v: Int) : (Int, Int) = {
        if (node == null) return (0,0)
        val left = path(node.left, node.value)
        val right = path(node.right, node.value)
        (
            left._1.max(right._1).max(left._2+right._2+1),
            if (node.value == v) left._2.max(right._2) + 1 else 0
        )
    }
}