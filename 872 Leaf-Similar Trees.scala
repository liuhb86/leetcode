/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
        leafSeq(root1, Nil) == leafSeq(root2, Nil)
    }
    
    def leafSeq(node: TreeNode, prev: List[Int]) : List[Int] = {
        if (node == null) return prev
        if (node.left == null && node.right == null) return node.value :: prev
        leafSeq(node.right, leafSeq(node.left, prev))
    }
}