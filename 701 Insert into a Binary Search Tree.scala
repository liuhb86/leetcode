/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
        if (root == null) return new TreeNode(`val`)
        if (`val` < root.value) root.left = insertIntoBST(root.left, `val`)
        else root.right = insertIntoBST(root.right, `val`)
        return root
    }
}