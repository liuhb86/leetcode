/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def findSecondMinimumValue(root: TreeNode): Int = {
        find(root).getOrElse(-1)
    }
    
    def find(root: TreeNode) : Option[Int] = {
        if (root == null || root.left == null) return None
        val l = if (root.left.value > root.value) Some(root.left.value) else find(root.left)
        val r = if (root.right.value > root.value) Some(root.right.value) else find(root.right)
        if (l.isEmpty) r
        else if (r.isEmpty) l
        else Some(scala.math.min(l.get, r.get))
    }
}