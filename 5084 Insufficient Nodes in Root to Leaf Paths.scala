/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def sufficientSubset(root: TreeNode, limit: Int): TreeNode = {
        remove(root, limit, 0)._1
    }
    
    def remove(node: TreeNode, limit: Int, sum: Int): (TreeNode, Int) = {
        if (node == null) return (null, 0)
        val left = remove(node.left, limit, sum + node.value)
        val right = remove(node.right, limit, sum+node.value)
        val maxValue = node.value + left._2.max(right._2)
        if (maxValue + sum < limit) return (null, maxValue)
        node.left = left._1
        node.right = right._1
        (node, maxValue)
    }
}