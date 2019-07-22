/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def subtreeWithAllDeepest(root: TreeNode): TreeNode = {
        dfs(root, 0)._1
    }
    
    def dfs(node: TreeNode, d: Int) : (TreeNode, Int) = {
        if (node == null) return (node, d)
        val left = dfs(node.left,d+1)
        val right = dfs(node.right, d+1)
        if (left._2 == right._2) {
            (node, left._2)
        } else if (left._2 > right._2) {
            left
        } else {
            right
        }
    }
}