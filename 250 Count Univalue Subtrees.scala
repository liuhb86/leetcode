/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def countUnivalSubtrees(root: TreeNode): Int = {
        dfs(root)._2
    }
    
    def dfs(node: TreeNode) : (Option[Int], Int) = {
        if (node == null) return (null, 0)
        val l = dfs(node.left)
        val r = dfs(node.right)
        var same = true
        if(l._1 != null) same = same && (l._1 == Some(node.value))
        if (r._1 != null) same = same && (r._1 == Some(node.value))
        if (same) (Some(node.value), l._2+r._2+1)
        else (None, l._2+r._2)
    }
}