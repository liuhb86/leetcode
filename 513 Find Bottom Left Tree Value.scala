/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def findBottomLeftValue(root: TreeNode): Int = {
        dfs(root, 0, (root.value, 0))._1
    }
    
    def dfs(node: TreeNode, d: Int, _r: (Int, Int)) : (Int, Int) = {
        var r = _r
        if (node == null) return r
        if (d>r._2) r = (node.value, d)
        r = dfs(node.left, d+1,r)
        r = dfs(node.right, d+1, r)
        r
    }
}