/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def deleteNode(root: TreeNode, key: Int): TreeNode = {
        if (root == null) return null
        if (root.value == key) return delete(root)
        if (root.value > key) {
            root.left = deleteNode(root.left, key)
        } else {
            root.right = deleteNode(root.right, key)
        }
        root
    }
    
    def delete(node: TreeNode) : TreeNode = {
        if (node.right == null) return node.left
        if (node.right.left == null) {
            node.right.left = node.left
            return node.right
        }
        var p = node.right
        while (p.left.left != null) p = p.left
        val root = p.left
        p.left = root.right
        root.left = node.left
        root.right = node.right
        root
    }
}