/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def insertIntoMaxTree(root: TreeNode, v: Int): TreeNode = {
        if (root == null) return new TreeNode(v)
        if (v > root.value) {
            val newNode = new TreeNode(v)
            newNode.left = root
            return newNode
        }
        root.right = insertIntoMaxTree(root.right, v)
        root
    }
}