/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def splitBST(root: TreeNode, V: Int): Array[TreeNode] = {
        if (root == null) return Array(null, null)
        if (V == root.value) {
            val right = root.right
            root.right = null
            Array(root, right)
        } else if (V < root.value) {
            val left = splitBST(root.left, V)
            root.left = left(1)
            Array(left(0),root)
        } else {
            val right = splitBST(root.right, V)
            root.right = right(0)
            Array(root, right(1))
        }    
    }
}