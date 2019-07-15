/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def lcaDeepestLeaves(root: TreeNode): TreeNode = {
        dfs(root, 0)._2
    }
    
    def dfs(node: TreeNode, d: Int) : (Int, TreeNode) = {
        if (node == null) return (0, null)
        if (node.left == null && node.right == null) return (d, node)
        val left = dfs(node.left,d+1)
        val right = dfs(node.right,d+1)
        if (left._1 == right._1) (left._1, node)
        else if (left._1 > right._1) left
        else right
    }
}