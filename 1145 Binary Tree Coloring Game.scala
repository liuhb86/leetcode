/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def btreeGameWinningMove(root: TreeNode, n: Int, x: Int): Boolean = {
        val count = find(root, x)
        val childs = count._1 + count._2 + 1
        val parents = n - childs
        if (parents > childs) return true
        val maxChild = count._1.max(count._2)
        val rest = n - maxChild
        if (maxChild > rest) return true
        false
    }
    
    def find(node: TreeNode, x: Int) : (Int, Int) =  {
        if (node == null) return null
        if (node.value == x) return (count(node.left), count(node.right))
        val left = find(node.left, x)
        if (left != null) return left
        find(node.right, x)
    }
    
    def count(node: TreeNode) : Int =  {
        if (node == null) return 0
        count(node.left) + count(node.right) + 1
    }
}