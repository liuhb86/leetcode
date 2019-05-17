/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def searchBST(root: TreeNode, `val`: Int): TreeNode = {
        val v = `val`
        if (root == null) null
        else if (root.value == v) root
        else if (root.value > v) searchBST(root.left, v)
        else searchBST(root.right, v)
    }
}