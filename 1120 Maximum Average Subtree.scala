/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def maximumAverageSubtree(root: TreeNode): Double = {
        dfs(root)._1
    }
    
    def dfs(node: TreeNode) : (Double, Int, Double) = {
        if (node == null) return (Double.NegativeInfinity, 0, 0.0)
        val left = dfs(node.left)
        val right = dfs(node.right)
        val count = left._2+right._2+1
        val sum = left._3+right._3+node.value
        ((sum/count).max(left._1).max(right._1), count, sum)
    }
}