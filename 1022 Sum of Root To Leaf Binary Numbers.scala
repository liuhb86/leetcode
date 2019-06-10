/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def sumRootToLeaf(root: TreeNode): Int = {
        sum(root, 0)
    }
    
    def sum(node: TreeNode, p: Int) : Int =  {
        if (node == null) return 0
        val v = (p <<1) + node.value 
        if (node.left == null && node.right == null) return v
        sum(node.left, v) + sum(node.right, v)
    }
}