/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def isCompleteTree(root: TreeNode): Boolean = {
        dfs(root, 0, null)._1
    }
    
    def dfs(node: TreeNode, h: Int, f: (Int, Boolean)) : (Boolean, (Int, Boolean)) = {
        if (node == null) {
            if (f == null) return (true, (h-1, true))
            if (h == f._1 + 1) return (true,f)
            if (h == f._1) return (true, (h, false))
            return (false, null)
        }
        
        if (f!= null) {
            if (h > f._1) return (false, null)
            if (h == f._1 && !f._2) return (false, null)
        }
        
        var r = dfs(node.left, h+1, f)
        if (!r._1) return r
        dfs(node.right, h+1, r._2)
    }
}