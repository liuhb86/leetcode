/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def convertBST(root: TreeNode): TreeNode = {
        convert(root, 0)
        root
    }
    
    def convert(node: TreeNode, sum: Int) : Int = {
        if (node == null) return sum
        node.value += convert(node.right, sum) 
        convert(node.left, + node.value)
    }
}