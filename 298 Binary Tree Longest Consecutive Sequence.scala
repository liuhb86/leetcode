/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def longestConsecutive(root: TreeNode): Int = {
        if (root == null) return 0
        dfs(root, root.value, 0)
    }
    
    def dfs(root:TreeNode, p: Int, c: Int) : Int = {
        if (root == null) return c
        val cr = if (root.value == p + 1) c + 1 else 1
        c.max(dfs(root.left, root.value, cr)).max(dfs(root.right, root.value, cr))
    }
}