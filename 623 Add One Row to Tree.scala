/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def addOneRow(root: TreeNode, v: Int, d: Int): TreeNode = {
        if (d==1) {
            val n = new TreeNode(v)
            n.left = root
            return n
        }
        dfs(root, 1, v, d)
    }
    
    def dfs(node: TreeNode, cd: Int, v: Int, d: Int) : TreeNode = {
        if (node == null) return null
        if (d==cd+1) {
            val left = new TreeNode(v)
            left.left = node.left
            val right = new TreeNode(v)
            right.right = node.right
            node.left = left
            node.right = right
            return node
        }
        node.left = dfs(node.left, cd+1,v,d)
        node.right = dfs(node.right, cd+1,v,d)
        node
    }
}