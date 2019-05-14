/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.math.max
object Solution {
    def rob(root: TreeNode): Int = {
        val r = _rob(root)
        max(r._1, r._2)
    }
    
    def _rob(node: TreeNode) : (Int, Int) = {
        if (node == null) return (0,0)
        val left = _rob(node.left)
        val right = _rob(node.right)
        println(s"${node.value}, $left,$right")
        (node.value + left._2 + right._2, max(left._1, left._2) + max(right._1, right._2)) 
    }
}