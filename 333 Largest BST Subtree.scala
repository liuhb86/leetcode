/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def largestBSTSubtree(root: TreeNode): Int = {
        return dfs(root)._4
    }
    
    def dfs(node: TreeNode) : (Boolean, Int, Int, Int) = {
        if (node == null) return (true, 0,0,0)
        val left = dfs(node.left)
        val right = dfs(node.right)
        if ((node.left == null || left._1 && left._3 < node.value)
            && (node.right == null || right._1 && right._2 > node.value)) {
            val lb = if (node.left != null) left._2 else node.value
            val ub = if (node.right != null) right._3 else node.value
            //println(true, node.value)
            return (true, lb, ub, left._4+right._4+1)
        } else {
            //println(false, node.value)
            return (false, 0,0, left._4.max(right._4))
        }
    }
}